from typing import List, Any, cast, Optional

from boa3.builtin import public, CreateNewEvent, contract, display_name
from boa3.builtin.interop import storage
from boa3.builtin.interop.contract import update_contract
from boa3.builtin.interop.runtime import check_witness, time
from boa3.builtin.interop.stdlib import serialize, deserialize
from boa3.builtin.interop.storage import get_context, find
from boa3.builtin.interop.storage.findoptions import FindOptions
from boa3.builtin.type import UInt160, ByteString

from smart_contracts.daonators_classes.campaign import Campaign
from smart_contracts.daonators_classes.org import Org

# Prefixes
PF_ORG = b'pforg'
PF_CMP = b'pfcmp'
PF_ACC = b'pfacc'   # será usada pra indicar qual campanha o usuário irá votar

# Getters constants
PERCENT_VOTES = b'prcvt'
LAST_WINNER = b'lswin'

NewOrgEvent = CreateNewEvent(
    [
        ('script_hash', UInt160),
        ('name', str),
    ],
    'Org added'
)

NewCampaignEvent = CreateNewEvent(
    [
        ('org_script_hash', UInt160),
        ('org_name', str),
    ],
    'Campaign created'
)

NewVoteEvent = CreateNewEvent(
    [
        ('voter_script_hash', UInt160),
        ('org_script_hash', UInt160),
        ('org_name', str),
    ],
    'Vote campaign added'
)

RemoveVoteEvent = CreateNewEvent(
    [
        ('voter_script_hash', UInt160),
        ('org_script_hash', UInt160),
        ('org_name', str),
    ],
    'Vote campaign removed'
)


@public
def get_campaigns() -> List[Campaign]:
    context = get_context()
    iterator = find(PF_CMP, context, FindOptions.VALUES_ONLY)
    campaigns: List[Campaign] = []

    while iterator.next():
        campaign: Campaign = deserialize(cast(bytes, iterator.value))
        campaigns.append(campaign)

    return campaigns


@public
def get_campaign(org_script_hash: UInt160) -> Optional[Campaign]:
    campaign_bytes = storage.get(_mk_cmp_key(org_script_hash))
    if len(campaign_bytes) == 0:
        return None

    return cast(Campaign, deserialize(campaign_bytes))


@public
def get_orgs() -> List[Org]:
    context = get_context()
    iterator = find(PF_ORG, context, FindOptions.VALUES_ONLY)
    orgs: List[Org] = []

    while iterator.next():
        org: Org = deserialize(cast(bytes, iterator.value))
        orgs.append(org)

    return orgs


@public
def get_account_voting(account_script_hash: UInt160) -> Optional[UInt160]:
    org_bytes = storage.get(_mk_acc_key(account_script_hash))
    if len(org_bytes) == 0:
        return None

    return UInt160(org_bytes)


@public
def get_org(org_script_hash: UInt160) -> Optional[Org]:
    org_bytes = storage.get(_mk_org_key(org_script_hash))
    if len(org_bytes) == 0:
        return None
    return cast(Org, deserialize(org_bytes))


@public
def add_organization(org_script_hash: UInt160, name: Optional[str]) -> bool:
    _org: Optional[Org] = get_org(org_script_hash)

    # check if org exists
    if _org is not None:
        return False

    new_org = Org(org_script_hash, name)
    _save_org(org_script_hash, new_org)

    return True


@public
def create_campaign(org_script_hash: UInt160) -> bool:
    # Pode ser que tenha uma verificação se:
    #   é administrador ou;
    #   se tem x tokens para poder criar a campanha.
    # Mas atualmente qualquer pessoa pode

    _org: Optional[Org] = get_org(org_script_hash)

    if _org is None:
        return False
    else:

        # verifica se ja existe campanha
        check_already_exists = get_campaign(org_script_hash)
        if check_already_exists is not None:
            return False

        # alguns problemas com a compilação se nao fizer esse cast
        org_selected = cast(Org, _org)
        campaign = Campaign(org_selected)

        _save_cmp(org_script_hash, campaign)
        NewCampaignEvent(org_selected.script_hash, org_selected.name)

        return True


@public
def vote(org_script_hash: UInt160, voter_script_hash: UInt160) -> bool:
    if not check_witness(voter_script_hash):
        return False

    # se não tiver tokens para votar entao retorna falso
    if Token.balance_of(voter_script_hash) <= 0:
        return False

    # se não existe campanha então não da pra votar
    if get_campaign(org_script_hash) is None:
        return False

    campaign: Campaign = get_campaign(org_script_hash)
    org_voted: Org = campaign.org_full

    voter_added = campaign.add_voter(voter_script_hash)
    # se adicionar o voto falhou, então retorna False
    if not voter_added:
        return False

    verify: Optional[Org] = get_account_voting(voter_script_hash)
    # se o usuário já está votando em alguém então é necessário remover esse voto
    if verify is not None:
        old_org: Org = verify
        old_org_script_hash = old_org.script_hash
        old_campaign: Campaign = get_campaign(old_org_script_hash)
        old_campaign.remove_voter(voter_script_hash)
        _save_cmp(old_org_script_hash, old_campaign)
        RemoveVoteEvent(voter_script_hash, old_org_script_hash, old_org.name)

    # salva as mudanças no storage
    _save_cmp(org_script_hash, campaign)
    _save_account_vote(voter_script_hash, org_script_hash)

    NewVoteEvent(voter_script_hash, org_voted.script_hash, org_voted.name)

    return True


@public
def remove_vote(org_script_hash: UInt160, voter_script_hash: UInt160) -> bool:
    if not check_witness(voter_script_hash):
        return False

    # se não existe campanha então não da para tirar o voto
    if get_campaign(org_script_hash) is None:
        return False

    campaign: Campaign = get_campaign(org_script_hash)
    org_voted: Org = campaign.org_full

    voter_removed = campaign.remove_voter(voter_script_hash)
    if not voter_removed:
        return False

    _save_cmp(org_script_hash, campaign)
    _remove_account_vote(voter_script_hash)
    RemoveVoteEvent(voter_script_hash, org_voted.script_hash, org_voted.name)

    return True


@public
def amount_to_donate() -> int:
    # ta sendo mockado atualmente, futuramente isso seria um balanceOf no NeoBurger desse contrato

    return time // 10000


@public
def _deploy(data: Any, update: bool):
    if not update:
        script_hash1 = UInt160(b'testeScriptHashNovo1')
        script_hash2 = UInt160(b'testeScriptHashNovo2')
        script_hash3 = UInt160(b'testeScriptHashNovo3')
        nome_org1 = 'criança feliz'
        nome_org2 = 'paz do amanhã'
        nome_org3 = 'felicidade do outro'
        test_org1 = Org(script_hash1, nome_org1)
        test_org2 = Org(script_hash2, nome_org2)
        test_org3 = Org(script_hash3, nome_org3)

        _save_org(script_hash1, test_org1)
        NewOrgEvent(script_hash1, nome_org1)

        _save_org(script_hash2, test_org2)
        NewOrgEvent(script_hash2, nome_org2)

        _save_org(script_hash3, test_org3)
        NewOrgEvent(script_hash3, nome_org3)

        create_campaign(script_hash1)


def _mk_org_key(org_address: UInt160) -> ByteString:
    return PF_ORG + org_address


def _mk_cmp_key(org_address: UInt160) -> ByteString:
    return PF_CMP + org_address


def _mk_acc_key(account_address: UInt160) -> ByteString:
    return PF_ACC + account_address


def _save_org(org_script_hash: UInt160, org: Org):
    storage.put(_mk_org_key(org_script_hash), serialize(org))


def _save_cmp(org_script_hash: UInt160, campaign: Campaign):
    storage.put(_mk_cmp_key(org_script_hash), serialize(campaign))


def _save_account_vote(account_script_hash: UInt160, org_script_hash: UInt160):
    storage.put(_mk_acc_key(account_script_hash), org_script_hash)


def _remove_account_vote(account_script_hash: UInt160):
    storage.delete(_mk_acc_key(account_script_hash))


@contract(b'ys\x91\xe04\xb3\x01\xe5\n8J\xdc\x96\x98\x92\xc2\xee\x93\xf2\xc7')
class Token:
    # token no teste b'\x9d\x1f0\x89\xc8L\x01\xf9w@\xfa\x1f\xa3!\x01bj\xbf\xd6\x8b'
    # token na TestNet b'ys\x91\xe04\xb3\x01\xe5\n8J\xdc\x96\x98\x92\xc2\xee\x93\xf2\xc7'
    # Tem que fazer o reverse nos dois casos

    @staticmethod
    @display_name('balanceOf')
    def balance_of(account: UInt160) -> int:
        pass


@public
def update(script: bytes, manifest: bytes, data: Any):
    update_contract(script, manifest, data)
