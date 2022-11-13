/**
 * Filter Schema of AuthAdm
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IAuthAdmCollectionResourcesHolder} from '@/model/collection/AuthAdmCollection'
import {AuthAdm} from '@/model/resource/AuthAdm'

/* TODO: review generated schema */
export class FilterAuthAdmSchema extends DefaultSchema
  implements IAuthAdmCollectionResourcesHolder {
  readonly name = 'FilterAuthAdm'

  readonly fieldSet: FieldSet<AuthAdm> = {}
}
