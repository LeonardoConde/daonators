/**
 * List Schema of Vote
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {Vote} from '@/model/resource/Vote'

/* TODO: review generated schema */
export class ListVoteSchema extends DefaultSchema {
  readonly name = 'ListVote'

  readonly fieldSet: FieldSet<Vote> = {
    idVotePk: (): FieldComponent => ({
      is: Component.Render,
    }),
    campaingOrganization: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.campaingOrganization?.$tag,
      },
    }),
    userWallet: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.userWallet?.$tag,
      },
    }),
    lastUpdate: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: $.filter.datetime(schema.model.lastUpdate),
      },
    }),
    tokensAmount: (): FieldComponent => ({
      is: Component.Render,
    }),
  }
}
