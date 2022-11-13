/**
 * Input Schema of VotingType
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {VotingType} from '@/model/resource/VotingType'

/* TODO: review generated schema */
export class InputVotingTypeSchema extends DefaultSchema {
  readonly name = 'InputVotingType'

  readonly fieldSet: FieldSet<VotingType> = {
    name: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'text',
        maxlength: 45,
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
    active: (schema): FieldComponent => ({
      is: Component.InputCheckbox,
      bind: {
        label: this.translateFrom(schema.fieldName),
        class: 'pretty p-switch p-fill justify-center mt-8',
        labelClass: 'relative state',
      },
    }),
  }
}
