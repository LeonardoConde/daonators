/**
 * Filter Schema of Vote
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IVoteCollectionResourcesHolder} from '@/model/collection/VoteCollection'
import {Vote} from '@/model/resource/Vote'
import {CampaingOrganizationCollection} from '@/model/collection/CampaingOrganizationCollection'
import {UserWalletCollection} from '@/model/collection/UserWalletCollection'

/* TODO: review generated schema */
export class FilterVoteSchema extends DefaultSchema
  implements IVoteCollectionResourcesHolder {
  collectionCampaingOrganization = new CampaingOrganizationCollection().noPagination()
  collectionUserWallet = new UserWalletCollection().noPagination()

  readonly name = 'FilterVote'

  readonly fieldSet: FieldSet<Vote> = {
    campaingOrganization: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        items: this.collectionCampaingOrganization.items,
        multiple: true,
        closeOnSelect: false,
        preserveSearch: true,
        label: this.translateFrom(schema.fieldName),
        trackBy: '$id',
        preselectFirst: true,
      },
    }),
    userWallet: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        items: this.collectionUserWallet.items,
        multiple: true,
        closeOnSelect: false,
        preserveSearch: true,
        label: this.translateFrom(schema.fieldName),
        trackBy: '$id',
        preselectFirst: true,
      },
    }),
    startLastUpdate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'date',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    endLastUpdate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'date',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    minIdOrganizationFk: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    maxIdOrganizationFk: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
