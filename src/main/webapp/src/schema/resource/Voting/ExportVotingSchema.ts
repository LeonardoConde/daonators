/**
 * Export Schema of Voting
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {Voting} from '@/model/resource/Voting'

/* TODO: review generated schema */
export class ExportVotingSchema extends DefaultSchema {
  readonly name = 'ExportVoting'

  readonly fieldSet: FieldSet<Voting> = {
    idVotingPk: schema => schema.model.idVotingPk,
    idOrganizationfk: schema => schema.model.idOrganizationfk,
    campaing: schema => schema.model.campaing?.$tag ?? null,
    organization: schema => schema.model.organization?.$tag ?? null,
    votingType: schema => schema.model.votingType?.$tag ?? null,
  }
}
