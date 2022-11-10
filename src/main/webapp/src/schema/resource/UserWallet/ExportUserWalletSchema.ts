/**
 * Export Schema of UserWallet
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {UserWallet} from '@/model/resource/UserWallet'

/* TODO: review generated schema */
export class ExportUserWalletSchema extends DefaultSchema {
  readonly name = 'ExportUserWallet'

  readonly fieldSet: FieldSet<UserWallet> = {
    idUserWalletPk: schema => schema.model.idUserWalletPk,
    walletAdress: schema => schema.model.walletAdress,
  }
}
