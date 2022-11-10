/**
 * Filter Schema of Voting
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IVotingCollectionResourcesHolder} from '@/model/collection/VotingCollection'
import {Voting} from '@/model/resource/Voting'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'
import {VotingTypeCollection} from '@/model/collection/VotingTypeCollection'

/* TODO: review generated schema */
export class FilterVotingSchema extends DefaultSchema
  implements IVotingCollectionResourcesHolder {
  collectionCampaing = new CampaingCollection().noPagination()
  collectionOrganization = new OrganizationCollection().noPagination()
  collectionVotingType = new VotingTypeCollection().noPagination()

  readonly name = 'FilterVoting'

  readonly fieldSet: FieldSet<Voting> = {
    campaing: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        items: this.collectionCampaing.items,
        multiple: true,
        closeOnSelect: false,
        preserveSearch: true,
        label: this.translateFrom(schema.fieldName),
        trackBy: '$id',
        preselectFirst: true,
      },
    }),
    votingType: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        items: this.collectionVotingType.items,
        multiple: true,
        closeOnSelect: false,
        preserveSearch: true,
        label: this.translateFrom(schema.fieldName),
        trackBy: '$id',
        preselectFirst: true,
      },
    }),
  }
}
