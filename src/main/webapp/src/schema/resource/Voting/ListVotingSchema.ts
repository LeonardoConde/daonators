/**
 * List Schema of Voting
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {Voting} from '@/model/resource/Voting'

/* TODO: review generated schema */
export class ListVotingSchema extends DefaultSchema {
  readonly name = 'ListVoting'

  readonly fieldSet: FieldSet<Voting> = {
    idVotingPk: (): FieldComponent => ({
      is: Component.Render,
    }),
    idOrganizationfk: (): FieldComponent => ({
      is: Component.Render,
    }),
    campaing: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.campaing?.$tag,
      },
    }),
    organization: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.organization?.$tag,
      },
    }),
    votingType: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.votingType?.$tag,
      },
    }),
  }
}
