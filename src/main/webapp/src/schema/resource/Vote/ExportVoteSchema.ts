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
    userWallet: schema => schema.model.userWallet?.$tag ?? null,
    voting: schema => schema.model.voting?.$tag ?? null,
    tokenAmount: schema => schema.model.tokenAmount,
  }
}
