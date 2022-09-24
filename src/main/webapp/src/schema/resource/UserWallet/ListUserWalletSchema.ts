/**
 * List Schema of UserWallet
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {UserWallet} from '@/model/resource/UserWallet'

/* TODO: review generated schema */
export class ListUserWalletSchema extends DefaultSchema {
  readonly name = 'ListUserWallet'

  readonly fieldSet: FieldSet<UserWallet> = {
    idUserWalletPk: (): FieldComponent => ({
      is: Component.Render,
    }),
    user: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.user?.$tag,
      },
    }),
    walletAddress: (): FieldComponent => ({
      is: Component.Render,
    }),
  }
}
