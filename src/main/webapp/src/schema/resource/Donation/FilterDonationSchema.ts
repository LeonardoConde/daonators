/**
 * Filter Schema of Donation
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {IDonationCollectionResourcesHolder} from '@/model/collection/DonationCollection'
import {Donation} from '@/model/resource/Donation'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated schema */
export class FilterDonationSchema extends DefaultSchema
  implements IDonationCollectionResourcesHolder {
  collectionCampaing = new CampaingCollection().noPagination()
  collectionOrganization = new OrganizationCollection().noPagination()

  readonly name = 'FilterDonation'

  readonly fieldSet: FieldSet<Donation> = {
    minGasAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        label: this.translateFrom(schema.fieldName),
      },
    }),
    maxGasAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
