/**
 * Input Schema of Wallet
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {Wallet} from '@/model/resource/Wallet'

/* TODO: review generated schema */
export class InputWalletSchema extends DefaultSchema {
  readonly name = 'InputWallet'

  readonly fieldSet: FieldSet<Wallet> = {
    wallet: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'text',
        maxlength: 45,
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
