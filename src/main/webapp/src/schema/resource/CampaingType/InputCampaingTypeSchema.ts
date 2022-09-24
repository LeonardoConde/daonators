/**
 * Input Schema of CampaingType
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {CampaingType} from '@/model/resource/CampaingType'

/* TODO: review generated schema */
export class InputCampaingTypeSchema extends DefaultSchema {
  readonly name = 'InputCampaingType'

  readonly fieldSet: FieldSet<CampaingType> = {
    active: (schema): FieldComponent => ({
      is: Component.InputCheckbox,
      bind: {
        label: this.translateFrom(schema.fieldName),
        class: 'pretty p-switch p-fill justify-center mt-8',
        labelClass: 'relative state',
      },
    }),
    name: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'text',
        maxlength: 45,
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
