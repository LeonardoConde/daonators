/**
 * Input Schema of Vote
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {Vote} from '@/model/resource/Vote'
import {UserWalletCollection} from '@/model/collection/UserWalletCollection'
import {VotingCollection} from '@/model/collection/VotingCollection'

/* TODO: review generated schema */
export class InputVoteSchema extends DefaultSchema {
  collectionUserWallet = new UserWalletCollection().noPagination()
  collectionVoting = new VotingCollection().noPagination()

  readonly name = 'InputVote'

  readonly fieldSet: FieldSet<Vote> = {
    userWallet: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionUserWallet.items,
      },
    }),
    voting: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionVoting.items,
      },
    }),
    tokenAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        maxlength: 255,
        step: 'any',
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
  }
}
