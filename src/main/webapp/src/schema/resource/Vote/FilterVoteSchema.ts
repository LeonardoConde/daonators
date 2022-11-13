/**
 * Filter Schema of Vote
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IVoteCollectionResourcesHolder} from '@/model/collection/VoteCollection'
import {Vote} from '@/model/resource/Vote'
import {UserWalletCollection} from '@/model/collection/UserWalletCollection'
import {VotingCollection} from '@/model/collection/VotingCollection'

/* TODO: review generated schema */
export class FilterVoteSchema extends DefaultSchema
  implements IVoteCollectionResourcesHolder {
  collectionUserWallet = new UserWalletCollection().noPagination()
  collectionVoting = new VotingCollection().noPagination()

  readonly name = 'FilterVote'

  readonly fieldSet: FieldSet<Vote> = {
    minTokenAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    maxTokenAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
