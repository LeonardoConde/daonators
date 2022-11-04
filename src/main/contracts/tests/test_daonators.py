from typing import List

from boa3.neo import to_script_hash
from boa3.neo.vm.type.String import String
from boa3_test.tests.boa_test import BoaTest
from boa3_test.tests.test_classes.TestExecutionException import TestExecutionException
from boa3_test.tests.test_classes.testengine import TestEngine
import pathlib


class TestDaonators(BoaTest):
    default_folder: str = str(pathlib.Path(__file__).parent.parent.resolve())
    print(default_folder)

    USER_SCRIPT_HASH_ONE = bytes(20)
    OTHER_ACCOUNT_1 = to_script_hash(b'NiNmXL8FjEUEs1nfX9uHFBNaenxDHJtmuB')
    OTHER_ACCOUNT_2 = bytes(range(20))
    engine = TestEngine(str(pathlib.Path(__file__).parent.parent.joinpath('Neo.TestEngine').resolve()))

    ORG_SCRIPT_HASH1 = b'testeScriptHashNovo1'
    ORG_SCRIPT_HASH2 = b'testeScriptHashNovo2'
    ORG_SCRIPT_HASH3 = b'testeScriptHashNovo3'
    ORG_SCRIPT_HASH4 = b'testeScriptHashNovo4'
    ORG_NAME1 = 'criança feliz'
    ORG_NAME2 = 'paz do amanhã'
    ORG_NAME3 = 'felicidade do outro'

    @property
    def path(self):
        return self.get_contract_path(self.default_folder, 'smart_contracts', 'daonators.py')

    @property
    def path_token(self):
        return self.get_contract_path(self.default_folder, 'smart_contracts', 'token.py')

    @property
    def path_test_engine(self):
        return str(pathlib.Path(__file__).parent.parent.joinpath('Neo.TestEngine').resolve())

    def test_dao_compile(self):
        self.compile_and_save(self.path)

    def test_dao_get_orgs(self):
        result = self.run_smart_contract(self.engine, self.path, 'get_orgs', expected_result_type=List[bytes])

        orgs_added = [
            [self.ORG_SCRIPT_HASH1.decode('utf-8'), self.ORG_NAME1],
            [self.ORG_SCRIPT_HASH2.decode('utf-8'), self.ORG_NAME2],
            [self.ORG_SCRIPT_HASH3.decode('utf-8'), self.ORG_NAME3],
        ]
        self.assertEqual(orgs_added, result)

    def test_dao_create_campaign_and_get(self):
        self.engine.reset_engine()

        # sem campanhas atualmente
        result = self.run_smart_contract(self.engine, self.path, 'get_campaigns')
        self.assertEqual([], result)

        # adicionar uma campanha com org que nao existe vai dar erro
        result = self.run_smart_contract(self.engine, self.path, 'create_campaign', self.ORG_SCRIPT_HASH4)
        self.assertEqual(False, result)

        qtd_eventos_antes = len(self.engine.notifications)

        # adicionar uma campanha nova usando uma org que já existe na lista
        result = self.run_smart_contract(self.engine, self.path, 'create_campaign', self.ORG_SCRIPT_HASH1)
        self.assertEqual(True, result)

        qtd_eventos_depois = len(self.engine.notifications)

        # um evento de criar campanha foi disparado
        self.assertEqual(qtd_eventos_depois, qtd_eventos_antes + 1)
        self.assertEqual(self.engine.notifications[-1].name, 'campaign_created')
        self.assertEqual(self.engine.notifications[-1].arguments[0], self.ORG_SCRIPT_HASH1.decode('utf-8'))
        self.assertEqual(self.engine.notifications[-1].arguments[1], self.ORG_NAME1)

        # verifica que a campanha foi criada
        campanha = self.run_smart_contract(self.engine, self.path, 'get_campaign', self.ORG_SCRIPT_HASH1)
        self.assertEqual([[self.ORG_SCRIPT_HASH1.decode('utf-8'), self.ORG_NAME1], []], campanha)

        # pega lista de campanhas
        lista_campanhas = self.run_smart_contract(self.engine, self.path, 'get_campaigns')
        self.assertEqual([campanha], lista_campanhas)

        # não pode criar a campanha duas vezes
        result = self.run_smart_contract(self.engine, self.path, 'create_campaign', self.ORG_SCRIPT_HASH1)
        self.assertEqual(False, result)

    def test_dao_vote_campaign(self):
        self.engine.reset_engine()
        self.engine.add_contract(self.path)
        self.engine.add_contract(self.path_token)

        self.run_smart_contract(self.engine, self.path_token, 'symbol')
        self.set_token_data()
        self.run_smart_contract(self.engine, self.path, 'get_orgs')

        # can't vote, because campaign doesn't exist yet
        result = self.run_smart_contract(self.engine, self.path, 'vote', self.ORG_SCRIPT_HASH1,
                                         self.USER_SCRIPT_HASH_ONE, signer_accounts=[self.USER_SCRIPT_HASH_ONE])
        self.assertEqual(False, result)

        result = self.run_smart_contract(self.engine, self.path, 'create_campaign', self.ORG_SCRIPT_HASH1)
        self.assertEqual(True, result)

        # user doesn't have any token to vote yet
        result = self.run_smart_contract(self.engine, self.path, 'vote', self.ORG_SCRIPT_HASH1,
                                         self.USER_SCRIPT_HASH_ONE, signer_accounts=[self.USER_SCRIPT_HASH_ONE])
        self.assertEqual(False, result)

        self.add_tokens_to_user(self.USER_SCRIPT_HASH_ONE, 10 * 10 ** 8)

        # now the user is able to vote
        result = self.run_smart_contract(self.engine, self.path, 'vote', self.ORG_SCRIPT_HASH1,
                                         self.USER_SCRIPT_HASH_ONE, signer_accounts=[self.USER_SCRIPT_HASH_ONE])
        self.assertEqual(True, result)

        # can't vote twice
        result = self.run_smart_contract(self.engine, self.path, 'vote', self.ORG_SCRIPT_HASH1,
                                         self.USER_SCRIPT_HASH_ONE, signer_accounts=[self.USER_SCRIPT_HASH_ONE])
        self.assertEqual(False, result)

        # pega a campanha pra verificar se o usuario esta na lista de votados
        result = self.run_smart_contract(self.engine, self.path, 'get_campaign', self.ORG_SCRIPT_HASH1)
        self.assertIn(self.USER_SCRIPT_HASH_ONE.decode('utf-8'), result[1])

        # não é possivel que outra pessoa remova sem permissão
        result = self.run_smart_contract(self.engine, self.path, 'remove_vote', self.ORG_SCRIPT_HASH1,
                                         self.USER_SCRIPT_HASH_ONE, signer_accounts=[self.OTHER_ACCOUNT_1])
        self.assertEqual(False, result)

        result = self.run_smart_contract(self.engine, self.path, 'remove_vote', self.ORG_SCRIPT_HASH1,
                                         self.USER_SCRIPT_HASH_ONE, signer_accounts=[self.USER_SCRIPT_HASH_ONE])
        self.assertEqual(True, result)

        # pega a campanha pra verificar que o usuario não esta na lista de votados
        result = self.run_smart_contract(self.engine, self.path, 'get_campaign', self.ORG_SCRIPT_HASH1)
        self.assertNotIn(self.USER_SCRIPT_HASH_ONE.decode('utf-8'), result[1])

    def set_token_data(self):
        total_supply = 10_000_000 * 10 ** 8
        token_address = self.engine.executed_script_hash.to_array()
        self.run_smart_contract(self.engine, self.path_token, 'fixTestEngineDeployError',
                                self.engine.notifications[0].arguments[0],
                                token_address, total_supply)

    def add_tokens_to_user(self, user_address, amount: int):
        self.run_smart_contract(self.engine, self.path_token, 'mint_for_tests', user_address, amount,
                                signer_accounts=[self.USER_SCRIPT_HASH_ONE])
