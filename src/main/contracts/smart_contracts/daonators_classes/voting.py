from typing import List
from boa3.builtin.type import UInt160


class TypeVoting:
    def __init__(self, voting_type_name: str, voting_id: int):
        self.id: int = voting_id
        self.nome: str = voting_type_name


class Voting:
    def __init__(self, voting_type: TypeVoting):
        self.campaigns_script_hash: List[UInt160] = []
        self.campaign_type: TypeVoting = voting_type

    def add_campaign(self, campaign_script_hash: UInt160) -> bool:
        if campaign_script_hash in self.campaigns_script_hash:
            return False

        self.campaigns_script_hash.append(campaign_script_hash)
        return True

    def remote_campaign(self, campaign_script_hash: UInt160) -> bool:
        if campaign_script_hash not in self.campaigns_script_hash:
            return False

        self.campaigns_script_hash.remove(campaign_script_hash)
        return True
