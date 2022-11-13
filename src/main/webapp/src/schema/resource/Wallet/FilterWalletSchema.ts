/**
 * Filter Schema of Wallet
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IWalletCollectionResourcesHolder} from '@/model/collection/WalletCollection'
import {Wallet} from '@/model/resource/Wallet'

/* TODO: review generated schema */
export class FilterWalletSchema extends DefaultSchema
  implements IWalletCollectionResourcesHolder {
  readonly name = 'FilterWallet'

  readonly fieldSet: FieldSet<Wallet> = {}
}
