/**
 * Export Schema of Donation
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {Donation} from '@/model/resource/Donation'

/* TODO: review generated schema */
export class ExportDonationSchema extends DefaultSchema {
  readonly name = 'ExportDonation'

  readonly fieldSet: FieldSet<Donation> = {
    idDonationPk: schema => schema.model.idDonationPk,
    campaing: schema => schema.model.campaing?.$tag ?? null,
    organization: schema => schema.model.organization?.$tag ?? null,
    transactionHash: schema => schema.model.transactionHash,
    gasAmount: schema => schema.model.gasAmount,
  }
}
