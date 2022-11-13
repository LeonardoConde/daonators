/**
 * Input Schema of Donation
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {Donation} from '@/model/resource/Donation'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated schema */
export class InputDonationSchema extends DefaultSchema {
  collectionCampaing = new CampaingCollection().noPagination()
  collectionOrganization = new OrganizationCollection().noPagination()

  readonly name = 'InputDonation'

  readonly fieldSet: FieldSet<Donation> = {
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
    transactionHash: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'text',
        maxlength: 66,
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
    gasAmount: (schema): FieldComponent => ({
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
