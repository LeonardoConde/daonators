/**
 * Export Schema of VotingType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {VotingType} from '@/model/resource/VotingType'

/* TODO: review generated schema */
export class ExportVotingTypeSchema extends DefaultSchema {
  readonly name = 'ExportVotingType'

  readonly fieldSet: FieldSet<VotingType> = {
    idVotingTypePk: schema => schema.model.idVotingTypePk,
    name: schema => schema.model.name,
    active: schema => $.filter.bool(schema.model.active),
  }
}
