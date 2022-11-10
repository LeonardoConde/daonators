/**
 * Filter Schema of Organization
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IOrganizationCollectionResourcesHolder} from '@/model/collection/OrganizationCollection'
import {Organization} from '@/model/resource/Organization'
import {CampaingCollection} from '@/model/collection/CampaingCollection'

/* TODO: review generated schema */
export class FilterOrganizationSchema extends DefaultSchema
  implements IOrganizationCollectionResourcesHolder {
  collectionCampaing = new CampaingCollection().noPagination()

  readonly name = 'FilterOrganization'

  readonly fieldSet: FieldSet<Organization> = {}
}
