from boa3.builtin.type import UInt160
from typing import Optional


class Org:
    def __init__(self, _script_hash: UInt160, _name: Optional[str] = None):
        if _name is None:
            _name: str = ''

        self.script_hash: UInt160 = _script_hash
        self.name: str = _name
