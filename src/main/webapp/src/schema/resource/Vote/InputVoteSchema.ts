/**
 * Input Schema of Vote
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {Vote} from '@/model/resource/Vote'
import {CampaingOrganizationCollection} from '@/model/collection/CampaingOrganizationCollection'
import {UserWalletCollection} from '@/model/collection/UserWalletCollection'

/* TODO: review generated schema */
export class InputVoteSchema extends DefaultSchema {
  collectionCampaingOrganization = new CampaingOrganizationCollection().noPagination()
  collectionUserWallet = new UserWalletCollection().noPagination()

  readonly name = 'InputVote'

  readonly fieldSet: FieldSet<Vote> = {
    campaingOrganization: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionCampaingOrganization.items,
      },
    }),
    userWallet: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionUserWallet.items,
      },
    }),
    lastUpdate: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'mask',
        maskPreset: 'datetime',
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
    tokensAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'text',
        maxlength: 255,
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
  }
}
