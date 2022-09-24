/**
 * Input Schema of CampaingOrganization
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {CampaingOrganization} from '@/model/resource/CampaingOrganization'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated schema */
export class InputCampaingOrganizationSchema extends DefaultSchema {
  collectionCampaing = new CampaingCollection().noPagination()
  collectionOrganization = new OrganizationCollection().noPagination()

  readonly name = 'InputCampaingOrganization'

  readonly fieldSet: FieldSet<CampaingOrganization> = {
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
      },
    }),
    gasAmount: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'number',
        maxlength: 255,
        step: 'any',
        label: this.translateFrom(schema.fieldName),
      },
    }),
  }
}
