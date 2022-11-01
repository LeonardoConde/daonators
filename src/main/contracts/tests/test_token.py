from boa3.neo import to_script_hash
from boa3.neo.vm.type.String import String
from boa3_test.tests.boa_test import BoaTest
from boa3_test.tests.test_classes.TestExecutionException import TestExecutionException
from boa3_test.tests.test_classes.testengine import TestEngine
import pathlib


class TestNEP17Template(BoaTest):
    default_folder: str = str(pathlib.Path(__file__).parent.parent.resolve())
    print(default_folder)

    OWNER_SCRIPT_HASH = bytes(20)
    OTHER_ACCOUNT_1 = to_script_hash(b'NiNmXL8FjEUEs1nfX9uHFBNaenxDHJtmuB')
    OTHER_ACCOUNT_2 = bytes(range(20))
    engine = TestEngine(str(pathlib.Path(__file__).parent.parent.joinpath('Neo.TestEngine').resolve()))

    @property
    def path(self):
        return self.get_contract_path(self.default_folder, 'smart_contracts', 'token.py')

    @property
    def path_test_engine(self):
        return str(pathlib.Path(__file__).parent.parent.joinpath('Neo.TestEngine').resolve())

    def test_nep17_compile(self):
        output, manifest = self.compile_and_save(self.path)

        self.assertIn('supportedstandards', manifest)
        self.assertIsInstance(manifest['supportedstandards'], list)
        self.assertGreater(len(manifest['supportedstandards']), 0)
        self.assertIn('NEP-17', manifest['supportedstandards'])

    def test_nep17_symbol(self):
        result = self.run_smart_contract(self.engine, self.path, 'symbol')
        self.assertEqual('DAONATOR', result)

    def test_nep17_decimals(self):
        result = self.run_smart_contract(self.engine, self.path, 'decimals')
        self.assertEqual(8, result)

    def test_nep17_total_supply(self):
        total_supply = 10_000_000 * 10 ** 8

        result = self.run_smart_contract(self.engine, self.path, 'totalSupply')
        self.assertEqual(total_supply, result)

    def test_nep17_total_balance_of(self):
        total_supply = 10_000_000 * 10 ** 8

        self.engine.reset_engine()

        self.engine.add_contract(self.path)

        self.run_smart_contract(self.engine, self.path, 'symbol')
        token_address = self.engine.executed_script_hash.to_array()

        self.run_smart_contract(self.engine, self.path, 'fixTestEngineDeployError',
                                self.engine.notifications[0].arguments[0],
                                token_address, total_supply)

        result = self.run_smart_contract(self.engine, self.path, 'balanceOf', self.OWNER_SCRIPT_HASH)
        self.assertEqual(0, result)

        result = self.run_smart_contract(self.engine, self.path, 'balanceOf', token_address)
        self.assertEqual(total_supply, result)

        # should fail when the script length is not 20
        with self.assertRaisesRegex(TestExecutionException, self.ASSERT_RESULTED_FALSE_MSG):
            self.run_smart_contract(self.engine, self.path, 'balanceOf', bytes(10))
        with self.assertRaisesRegex(TestExecutionException, self.ASSERT_RESULTED_FALSE_MSG):
            self.run_smart_contract(self.engine, self.path, 'balanceOf', bytes(30))

    def test_nep17_total_transfer(self):
        transferred_amount = 10 * 10 ** 8  # 10 tokens

        # TestEngine error fix
        total_supply = 10_000_000 * 10 ** 8
        self.run_smart_contract(self.engine, self.path, 'symbol')
        token_address = self.engine.executed_script_hash.to_array()
        self.run_smart_contract(self.engine, self.path, 'fixTestEngineDeployError',
                                self.engine.notifications[0].arguments[0],
                                token_address, total_supply)
        self.run_smart_contract(self.engine, self.path, 'mint_for_tests', self.OWNER_SCRIPT_HASH, transferred_amount * 10)

        # should fail if the sender doesn't sign
        result = self.run_smart_contract(self.engine, self.path, 'transfer',
                                         self.OWNER_SCRIPT_HASH, self.OTHER_ACCOUNT_1, transferred_amount, None)
        self.assertEqual(False, result)

        # should fail if the sender doesn't have enough balance
        result = self.run_smart_contract(self.engine, self.path, 'transfer',
                                         self.OTHER_ACCOUNT_1, self.OWNER_SCRIPT_HASH, transferred_amount, None,
                                         signer_accounts=[self.OTHER_ACCOUNT_1])
        self.assertEqual(False, result)

        # should fail when any of the scripts' length is not 20
        with self.assertRaisesRegex(TestExecutionException, self.ASSERT_RESULTED_FALSE_MSG):
            self.run_smart_contract(self.engine, self.path, 'transfer',
                                    self.OWNER_SCRIPT_HASH, bytes(10), transferred_amount, "")
        with self.assertRaisesRegex(TestExecutionException, self.ASSERT_RESULTED_FALSE_MSG):
            self.run_smart_contract(self.engine, self.path, 'transfer',
                                    bytes(10), self.OTHER_ACCOUNT_1, transferred_amount, "")

        # should fail when the amount is less than 0
        with self.assertRaisesRegex(TestExecutionException, self.ASSERT_RESULTED_FALSE_MSG):
            self.run_smart_contract(self.engine, self.path, 'transfer',
                                    self.OTHER_ACCOUNT_1, self.OWNER_SCRIPT_HASH, -10, None)

        # fire the transfer event when transferring to yourself
        balance_before = self.run_smart_contract(self.engine, self.path, 'balanceOf', self.OWNER_SCRIPT_HASH)
        result = self.run_smart_contract(self.engine, self.path, 'transfer',
                                         self.OWNER_SCRIPT_HASH, self.OWNER_SCRIPT_HASH, transferred_amount, None,
                                         signer_accounts=[self.OWNER_SCRIPT_HASH])
        self.assertEqual(True, result)
        transfer_events = self.engine.get_events('Transfer')
        self.assertEqual(3, len(transfer_events))
        self.assertEqual(3, len(transfer_events[2].arguments))

        sender, receiver, amount = transfer_events[2].arguments
        if isinstance(sender, str):
            sender = String(sender).to_bytes()
        if isinstance(receiver, str):
            receiver = String(receiver).to_bytes()
        self.assertEqual(self.OWNER_SCRIPT_HASH, sender)
        self.assertEqual(self.OWNER_SCRIPT_HASH, receiver)
        self.assertEqual(transferred_amount, amount)

        # transferring to yourself doesn't change the balance
        balance_after = self.run_smart_contract(self.engine, self.path, 'balanceOf', self.OWNER_SCRIPT_HASH)
        self.assertEqual(balance_before, balance_after)

        # does fire the transfer event
        balance_sender_before = self.run_smart_contract(self.engine, self.path, 'balanceOf', self.OWNER_SCRIPT_HASH)
        balance_receiver_before = self.run_smart_contract(self.engine, self.path, 'balanceOf', self.OTHER_ACCOUNT_1)
        result = self.run_smart_contract(self.engine, self.path, 'transfer',
                                         self.OWNER_SCRIPT_HASH, self.OTHER_ACCOUNT_1, transferred_amount, None,
                                         signer_accounts=[self.OWNER_SCRIPT_HASH])
        self.assertEqual(True, result)
        transfer_events = self.engine.get_events('Transfer')
        self.assertEqual(4, len(transfer_events))
        self.assertEqual(3, len(transfer_events[3].arguments))

        sender, receiver, amount = transfer_events[3].arguments
        if isinstance(sender, str):
            sender = String(sender).to_bytes()
        if isinstance(receiver, str):
            receiver = String(receiver).to_bytes()
        self.assertEqual(self.OWNER_SCRIPT_HASH, sender)
        self.assertEqual(self.OTHER_ACCOUNT_1, receiver)
        self.assertEqual(transferred_amount, amount)

        # transferring to someone other than yourself does change the balance
        balance_sender_after = self.run_smart_contract(self.engine, self.path, 'balanceOf', self.OWNER_SCRIPT_HASH)
        balance_receiver_after = self.run_smart_contract(self.engine, self.path, 'balanceOf', self.OTHER_ACCOUNT_1)
        self.assertEqual(balance_sender_before - transferred_amount, balance_sender_after)
        self.assertEqual(balance_receiver_before + transferred_amount, balance_receiver_after)

    def test_nep17_on_nep17_payment(self):
        with self.assertRaises(TestExecutionException):
            self.run_smart_contract(self.engine, self.path, 'onNEP17Transfer',
                                    self.OWNER_SCRIPT_HASH, 0, None)
