from typing import Any, Union

from boa3.builtin import NeoMetadata, metadata, public
from boa3.builtin.contract import Nep17TransferEvent, abort
from boa3.builtin.interop import runtime, storage
from boa3.builtin.interop.blockchain import Transaction
from boa3.builtin.interop.contract import GAS as GAS_SCRIPT, NEO as NEO_SCRIPT, call_contract
from boa3.builtin.interop.runtime import executing_script_hash, notify
from boa3.builtin.nativecontract.contractmanagement import ContractManagement
from boa3.builtin.type import UInt160, ByteString


# -------------------------------------------
# METADATA
# -------------------------------------------

@metadata
def manifest_metadata() -> NeoMetadata:
    """
    Defines this smart contract's metadata information
    """
    meta = NeoMetadata()
    meta.supported_standards = ['NEP-17']
    meta.add_permission(methods=['onNEP17Payment'])

    meta.author = ""
    meta.description = ""
    meta.email = ""
    return meta


# -------------------------------------------
# TOKEN SETTINGS
# -------------------------------------------


# Script hash of the contract owner
ADM = b'ad'
SUPPLY_KEY = b'ts'

ACCOUNT_PREFIX = b'ap'

# Symbol of the Token
TOKEN_SYMBOL = 'DAONATOR'

# Number of decimal places
TOKEN_DECIMALS = 8

# Total Supply of tokens in the system
TOKEN_TOTAL_SUPPLY = 10_000_000 * (10 ** TOKEN_DECIMALS)  # 10m total supply * 10^8 (decimals)


# -------------------------------------------
# Events
# -------------------------------------------


on_transfer = Nep17TransferEvent


# -------------------------------------------
# Methods
# -------------------------------------------


@public(safe=True)
def symbol() -> str:
    return TOKEN_SYMBOL


@public(safe=True)
def decimals() -> int:
    return TOKEN_DECIMALS


@public(name='totalSupply', safe=True)
def total_supply() -> int:
    return storage.get(SUPPLY_KEY).to_int()


@public(name='balanceOf', safe=True)
def balance_of(account: UInt160) -> int:
    assert len(account) == 20
    return get_account_balance(account)


@public
def transfer(from_address: UInt160, to_address: UInt160, amount: int, data: Any) -> bool:
    # the parameters from and to should be 20-byte addresses. If not, this method should throw an exception.
    assert len(from_address) == 20 and len(to_address) == 20
    # the parameter amount must be greater than or equal to 0. If not, this method should throw an exception.
    assert amount >= 0

    # The function MUST return false if the from account balance does not have enough tokens to spend.
    from_balance = get_account_balance(from_address)
    if from_balance < amount:
        return False

    # The function should check whether the from address equals the caller contract hash.
    # If so, the transfer should be processed;
    # If not, the function should use the check_witness to verify the transfer.
    if from_address != runtime.calling_script_hash:
        if not runtime.check_witness(from_address):
            return False

    # skip balance changes if transferring to yourself or transferring 0 cryptocurrency
    if from_address != to_address and amount != 0:
        notify(amount, 'amount')
        notify(from_address, 'from_address')
        notify(to_address, 'to_address')

        if from_balance == amount:
            storage.delete(from_address)
        else:
            change_account_balance(from_address, from_balance - amount)
            notify(from_balance - amount, 'from_balance - amount')

        to_balance = get_account_balance(to_address)
        change_account_balance(to_address, to_balance + amount)

        notify(to_balance + amount, 'to_balance + amount')

    # if the method succeeds, it must fire the transfer event
    on_transfer(from_address, to_address, amount)
    # if the to_address is a smart contract, it must call the contracts onPayment
    post_transfer(from_address, to_address, amount, data)
    # and then it must return true
    return True


def post_transfer(from_address: Union[UInt160, None], to_address: Union[UInt160, None], amount: int, data: Any):
    if to_address is not None:
        contract = ContractManagement.get_contract(to_address)
        if contract is not None:
            call_contract(to_address, 'onNEP17Payment', [from_address, amount, data])


@public
def _deploy(data: Any, update: bool):
    if not update:
        # setup instructions that will be executed when the smart contract is deployed
        container: Transaction = runtime.script_container
        deployer_account = UInt160(container.sender)
        runtime.check_witness(deployer_account)

        if not has_adm():
            # deletar depois
            notify(executing_script_hash, 'executing_script_hash error')

            storage.put(SUPPLY_KEY, TOKEN_TOTAL_SUPPLY)
            storage.put(ACCOUNT_PREFIX + executing_script_hash, TOKEN_TOTAL_SUPPLY)
            storage.put(ADM, deployer_account)

            on_transfer(None, executing_script_hash, TOKEN_TOTAL_SUPPLY)


@public(name='onNEP17Payment')
def on_nep17_payment(from_address: UInt160, amount: int, data: Any):
    # Use calling_script_hash to identify if the incoming token is NEO or GAS
    abort()


@public
def get_ownerless_tokens() -> int:
    return storage.get(ACCOUNT_PREFIX + executing_script_hash).to_int()


@public
def get_adm() -> UInt160:
    return UInt160(storage.get(ADM))


# Remover depois
@public
def fixTestEngineDeployError(wrong_address: UInt160, correct_address: UInt160, value: int):
    storage.put(mk_account(wrong_address), 0)
    storage.put(mk_account(correct_address), value)


# Método para mockar valores
@public
def mint_for_tests(address: UInt160, valor: int):
    storage.put(mk_account(address), valor)
    on_transfer(None, address, valor)


# Helpers


def mk_account(address: UInt160) -> ByteString:
    return ACCOUNT_PREFIX + address


def get_account_balance(address: UInt160) -> int:
    return storage.get(mk_account(address)).to_int()


def has_adm() -> bool:
    return len(storage.get(ADM)) > 0


def change_account_balance(address: UInt160, value: int):
    storage.put(mk_account(address), value)
