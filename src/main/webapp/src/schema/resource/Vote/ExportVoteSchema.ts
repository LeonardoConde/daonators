/**
 * Export Schema of Vote
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {Vote} from '@/model/resource/Vote'

/* TODO: review generated schema */
export class ExportVoteSchema extends DefaultSchema {
  readonly name = 'ExportVote'

  readonly fieldSet: FieldSet<Vote> = {
    idVotePk: schema => schema.model.idVotePk,
    campaingOrganization: schema =>
      schema.model.campaingOrganization?.$tag ?? null,
    userWallet: schema => schema.model.userWallet?.$tag ?? null,
    lastUpdate: schema => $.filter.datetime(schema.model.lastUpdate),
    tokensAmount: schema => schema.model.tokensAmount,
  }
}
