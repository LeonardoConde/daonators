/**
 * Filter Schema of OrganizationType
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IOrganizationTypeCollectionResourcesHolder} from '@/model/collection/OrganizationTypeCollection'
import {OrganizationType} from '@/model/resource/OrganizationType'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated schema */
export class FilterOrganizationTypeSchema extends DefaultSchema
  implements IOrganizationTypeCollectionResourcesHolder {
  collectionOrganization = new OrganizationCollection().noPagination()

  readonly name = 'FilterOrganizationType'

  readonly fieldSet: FieldSet<OrganizationType> = {}
}
