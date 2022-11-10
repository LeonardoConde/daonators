/**
 * List Schema of Donation
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {Donation} from '@/model/resource/Donation'

/* TODO: review generated schema */
export class ListDonationSchema extends DefaultSchema {
  readonly name = 'ListDonation'

  readonly fieldSet: FieldSet<Donation> = {
    idDonationPk: (): FieldComponent => ({
      is: Component.Render,
    }),
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
