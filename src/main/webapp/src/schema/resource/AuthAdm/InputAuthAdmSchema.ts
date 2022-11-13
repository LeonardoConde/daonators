/**
 * Input Schema of AuthAdm
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {AuthAdm} from '@/model/resource/AuthAdm'

/* TODO: review generated schema */
export class InputAuthAdmSchema extends DefaultSchema {
  readonly name = 'InputAuthAdm'

  readonly fieldSet: FieldSet<AuthAdm> = {
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
    email: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'email',
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required|email',
      },
    }),
    password: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'password',
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
  }
}
