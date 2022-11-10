/**
 * Export Schema of Campaing
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {Campaing} from '@/model/resource/Campaing'

/* TODO: review generated schema */
export class ExportCampaingSchema extends DefaultSchema {
  readonly name = 'ExportCampaing'

  readonly fieldSet: FieldSet<Campaing> = {
    idCampaingPk: schema => schema.model.idCampaingPk,
    socialCause: schema => schema.model.socialCause,
    beginDate: schema => $.filter.datetime(schema.model.beginDate),
    endDate: schema => $.filter.datetime(schema.model.endDate),
    name: schema => schema.model.name,
  }
}
