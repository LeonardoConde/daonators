/**
 * Filter Schema of CampaingOrganization
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {ICampaingOrganizationCollectionResourcesHolder} from '@/model/collection/CampaingOrganizationCollection'
import {CampaingOrganization} from '@/model/resource/CampaingOrganization'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated schema */
export class FilterCampaingOrganizationSchema extends DefaultSchema
  implements ICampaingOrganizationCollectionResourcesHolder {
  collectionCampaing = new CampaingCollection().noPagination()
  collectionOrganization = new OrganizationCollection().noPagination()

  readonly name = 'FilterCampaingOrganization'

  readonly fieldSet: FieldSet<CampaingOrganization> = {
    minGasAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    maxGasAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
