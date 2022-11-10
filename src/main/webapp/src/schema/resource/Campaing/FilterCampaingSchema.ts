/**
 * Filter Schema of Campaing
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {ICampaingCollectionResourcesHolder} from '@/model/collection/CampaingCollection'
import {Campaing} from '@/model/resource/Campaing'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated schema */
export class FilterCampaingSchema extends DefaultSchema
  implements ICampaingCollectionResourcesHolder {
  collectionOrganization = new OrganizationCollection().noPagination()

  readonly name = 'FilterCampaing'

  readonly fieldSet: FieldSet<Campaing> = {
    startBeginDate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'date',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    endBeginDate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'date',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    startEndDate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'date',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    endEndDate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'date',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
