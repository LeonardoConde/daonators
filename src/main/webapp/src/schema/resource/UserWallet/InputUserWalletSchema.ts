/**
 * Input Schema of UserWallet
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {UserWallet} from '@/model/resource/UserWallet'

/* TODO: review generated schema */
export class InputUserWalletSchema extends DefaultSchema {
  readonly name = 'InputUserWallet'

  readonly fieldSet: FieldSet<UserWallet> = {
    walletAddress: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'text',
        maxlength: 34,
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
  }
}
