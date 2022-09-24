/**
 * Filter Schema of UserWallet
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IUserWalletCollectionResourcesHolder} from '@/model/collection/UserWalletCollection'
import {UserWallet} from '@/model/resource/UserWallet'
import {UserCollection} from '@/model/collection/UserCollection'

/* TODO: review generated schema */
export class FilterUserWalletSchema extends DefaultSchema
  implements IUserWalletCollectionResourcesHolder {
  collectionUser = new UserCollection().noPagination()

  readonly name = 'FilterUserWallet'

  readonly fieldSet: FieldSet<UserWallet> = {
    user: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        items: this.collectionUser.items,
        multiple: true,
        closeOnSelect: false,
        preserveSearch: true,
        label: this.translateFrom(schema.fieldName),
        trackBy: '$id',
        preselectFirst: true,
      },
    }),
  }
}
