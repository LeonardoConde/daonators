from boa3.builtin.type import UInt160
from typing import List, Any

from smart_contracts.daonators_classes.org import Org


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

    def add_voter(self, voter_script_hash: UInt160) -> bool:
        if voter_script_hash in self.voters:
            return False

        self.voters.append(voter_script_hash)
        return True

    def remove_voter(self, voter_script_hash: UInt160) -> bool:
        if voter_script_hash not in self.voters:
            return False

        self.voters.remove(voter_script_hash)
        return True
