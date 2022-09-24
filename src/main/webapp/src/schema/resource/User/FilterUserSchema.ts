/**
 * Filter Schema of User
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IUserCollectionResourcesHolder} from '@/model/collection/UserCollection'
import {User} from '@/model/resource/User'

/* TODO: review generated schema */
export class FilterUserSchema extends DefaultSchema
  implements IUserCollectionResourcesHolder {
  readonly name = 'FilterUser'

  readonly fieldSet: FieldSet<User> = {}
}
