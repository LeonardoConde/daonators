/**
 * Filter Schema of VotingType
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IVotingTypeCollectionResourcesHolder} from '@/model/collection/VotingTypeCollection'
import {VotingType} from '@/model/resource/VotingType'

/* TODO: review generated schema */
export class FilterVotingTypeSchema extends DefaultSchema
  implements IVotingTypeCollectionResourcesHolder {
  readonly name = 'FilterVotingType'

  readonly fieldSet: FieldSet<VotingType> = {}
}
