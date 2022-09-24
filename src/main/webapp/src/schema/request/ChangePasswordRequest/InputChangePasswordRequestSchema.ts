/**
 * Input Schema of ChangePasswordRequest
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {ChangePasswordRequest} from '@/model/request/ChangePasswordRequest'

/* TODO: review generated schema */
export class InputChangePasswordRequestSchema extends DefaultSchema {
  readonly name = 'InputChangePasswordRequest'

  readonly fieldSet: FieldSet<ChangePasswordRequest> = {
    currentPassword: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'password',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    newPassword: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'password',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    confirmPassword: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'password',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
