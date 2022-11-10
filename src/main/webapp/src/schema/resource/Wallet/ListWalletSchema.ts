/**
 * List Schema of Wallet
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {Wallet} from '@/model/resource/Wallet'

/* TODO: review generated schema */
export class ListWalletSchema extends DefaultSchema {
  readonly name = 'ListWallet'

  readonly fieldSet: FieldSet<Wallet> = {
    idWalletPk: (): FieldComponent => ({
      is: Component.Render,
    }),
    wallet: (): FieldComponent => ({
      is: Component.Render,
    }),
  }
}
