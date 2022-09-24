/**
 * List Schema of CampaingOrganization
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {CampaingOrganization} from '@/model/resource/CampaingOrganization'

/* TODO: review generated schema */
export class ListCampaingOrganizationSchema extends DefaultSchema {
  readonly name = 'ListCampaingOrganization'

  readonly fieldSet: FieldSet<CampaingOrganization> = {
    campaing: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.campaing?.$tag,
      },
    }),
    organization: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.organization?.$tag,
      },
    }),
    transactionHash: (): FieldComponent => ({
      is: Component.Render,
    }),
    gasAmount: (): FieldComponent => ({
      is: Component.Render,
    }),
  }
}
