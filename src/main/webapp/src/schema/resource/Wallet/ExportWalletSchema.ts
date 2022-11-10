/**
 * Export Schema of Wallet
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {Wallet} from '@/model/resource/Wallet'

/* TODO: review generated schema */
export class ExportWalletSchema extends DefaultSchema {
  readonly name = 'ExportWallet'

  readonly fieldSet: FieldSet<Wallet> = {
    idWalletPk: schema => schema.model.idWalletPk,
    wallet: schema => schema.model.wallet,
  }
}
