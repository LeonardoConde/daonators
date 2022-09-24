/**
 * Input Schema of User
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {User} from '@/model/resource/User'

/* TODO: review generated schema */
export class InputUserSchema extends DefaultSchema {
  readonly name = 'InputUser'

  readonly fieldSet: FieldSet<User> = {
    idUser: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        maxlength: 255,
        step: 1,
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
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
    email: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'email',
        label: this.translateFrom(schema.fieldName),
        validation: 'email',
      },
    }),
    password: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'password',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
