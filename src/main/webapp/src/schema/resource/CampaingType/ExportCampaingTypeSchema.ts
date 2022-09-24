/**
 * Export Schema of CampaingType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {CampaingType} from '@/model/resource/CampaingType'

/* TODO: review generated schema */
export class ExportCampaingTypeSchema extends DefaultSchema {
  readonly name = 'ExportCampaingType'

  readonly fieldSet: FieldSet<CampaingType> = {
    idCampaingTypePk: schema => schema.model.idCampaingTypePk,
    active: schema => $.filter.bool(schema.model.active),
    name: schema => schema.model.name,
  }
}
