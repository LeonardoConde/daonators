/**
 * Filter Schema of UserWallet
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IUserWalletCollectionResourcesHolder} from '@/model/collection/UserWalletCollection'
import {UserWallet} from '@/model/resource/UserWallet'

/* TODO: review generated schema */
export class FilterUserWalletSchema extends DefaultSchema
  implements IUserWalletCollectionResourcesHolder {
  readonly name = 'FilterUserWallet'

  readonly fieldSet: FieldSet<UserWallet> = {}
}
