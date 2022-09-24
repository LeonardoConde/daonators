/**
 * Export Schema of CampaingOrganization
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {CampaingOrganization} from '@/model/resource/CampaingOrganization'

/* TODO: review generated schema */
export class ExportCampaingOrganizationSchema extends DefaultSchema {
  readonly name = 'ExportCampaingOrganization'

  readonly fieldSet: FieldSet<CampaingOrganization> = {
    campaing: schema => schema.model.campaing?.$tag ?? null,
    organization: schema => schema.model.organization?.$tag ?? null,
    transactionHash: schema => schema.model.transactionHash,
    gasAmount: schema => schema.model.gasAmount,
  }
}
