/**
 * Input Schema of Campaing
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {Campaing} from '@/model/resource/Campaing'
import {CampaingTypeCollection} from '@/model/collection/CampaingTypeCollection'

/* TODO: review generated schema */
export class InputCampaingSchema extends DefaultSchema {
  collectionCampaingType = new CampaingTypeCollection().noPagination()

  readonly name = 'InputCampaing'

  readonly fieldSet: FieldSet<Campaing> = {
    campaingType: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionCampaingType.items,
      },
    }),
    beginDate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'datetime',
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
    endDate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'datetime',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
