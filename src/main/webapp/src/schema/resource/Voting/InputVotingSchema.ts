/**
 * Input Schema of Voting
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {Voting} from '@/model/resource/Voting'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'
import {VotingTypeCollection} from '@/model/collection/VotingTypeCollection'

/* TODO: review generated schema */
export class InputVotingSchema extends DefaultSchema {
  collectionCampaing = new CampaingCollection().noPagination()
  collectionOrganization = new OrganizationCollection().noPagination()
  collectionVotingType = new VotingTypeCollection().noPagination()

  readonly name = 'InputVoting'

  readonly fieldSet: FieldSet<Voting> = {
    idOrganizationfk: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        maxlength: 255,
        step: 1,
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
    campaing: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionCampaing.items,
      },
    }),
    organization: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionOrganization.items,
      },
    }),
    votingType: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionVotingType.items,
      },
    }),
  }
}
