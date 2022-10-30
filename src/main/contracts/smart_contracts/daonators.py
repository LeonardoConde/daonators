from typing import List, Any, cast, Optional

from boa3.builtin import NeoMetadata, metadata, public, CreateNewEvent
from boa3.builtin.contract import Nep17TransferEvent, abort
from boa3.builtin.interop import runtime, storage
from boa3.builtin.interop.blockchain import Transaction
from boa3.builtin.interop.contract import GAS as GAS_SCRIPT, NEO as NEO_SCRIPT, call_contract
from boa3.builtin.interop.runtime import executing_script_hash, notify
from boa3.builtin.interop.stdlib import serialize, deserialize
from boa3.builtin.nativecontract.contractmanagement import ContractManagement
from boa3.builtin.interop.storage import get_context, find
from boa3.builtin.interop.storage.findoptions import FindOptions
from boa3.builtin.type import UInt160, ByteString

# Prefixes
PF_ORG = b'pforg'
PF_CMP = b'pfcmp'

# Getters constants
PERCENT_VOTES = b'prcvt'
LAST_WINNER = b'lswin'

NewOrgEvent = CreateNewEvent(
    [
        ('script_hash', UInt160),
        ('name', str),
    ],
    'org_added'
)

NewCampaignEvent = CreateNewEvent(
    [
        ('org_script_hash', UInt160),
        ('org_name', str),
    ],
    'campaign_created'
)


class Org:
    def __init__(self, _script_hash: UInt160, _name: str = ''):
        self.script_hash: UInt160 = _script_hash
        self.name: str = _name


class Campaign:
    def __init__(self, org_: Org):
        self._org: Org = org_
        self.voters: List[Any] = []

    @property
    def org_script_hash(self) -> UInt160:
        return self._org.script_hash

    @property
    def org_name(self) -> str:
        return self._org.name

    @property
    def org_full(self) -> Org:
        return self._org

    def get_quantity_of_votes(self):
        # do balanceOf voters
        pass


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
def get_org(org_script_hash: UInt160) -> Optional[Org]:
    org_bytes = storage.get(_mk_org_key(org_script_hash))
    if len(org_bytes) == 0:
        return None
    return cast(Org, deserialize(org_bytes))


@public
def create_campaign(org_script_hash: UInt160) -> bool:
    # pode ser que tenha uma verificação se é adm ou se tem x tokens pra poder criar a campanha,
    # mas atualmente qualquer pessoa pode

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


def _mk_org_key(org_address: UInt160) -> ByteString:
    return PF_ORG + org_address


def _mk_cmp_key(org_address: UInt160) -> ByteString:
    return PF_CMP + org_address


def _save_org(org_script_hash: UInt160, org: Org):
    storage.put(_mk_org_key(org_script_hash), serialize(org))


def _save_cmp(org_script_hash: UInt160, campaign: Campaign):
    storage.put(_mk_cmp_key(org_script_hash), serialize(campaign))
