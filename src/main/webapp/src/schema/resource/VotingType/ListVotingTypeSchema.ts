/**
 * List Schema of VotingType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {VotingType} from '@/model/resource/VotingType'

/* TODO: review generated schema */
export class ListVotingTypeSchema extends DefaultSchema {
  readonly name = 'ListVotingType'

  readonly fieldSet: FieldSet<VotingType> = {
    idVotingTypePk: (): FieldComponent => ({
      is: Component.Render,
    }),
    name: (): FieldComponent => ({
      is: Component.Render,
    }),
    active: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: $.filter.bool(schema.model.active),
      },
    }),
  }
}
