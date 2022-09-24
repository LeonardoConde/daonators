/**
 * List Schema of Campaing
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {Campaing} from '@/model/resource/Campaing'

/* TODO: review generated schema */
export class ListCampaingSchema extends DefaultSchema {
  readonly name = 'ListCampaing'

  readonly fieldSet: FieldSet<Campaing> = {
    idCampaingPk: (): FieldComponent => ({
      is: Component.Render,
    }),
    campaingType: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.campaingType?.$tag,
      },
    }),
    beginDate: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: $.filter.datetime(schema.model.beginDate),
      },
    }),
    endDate: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: $.filter.datetime(schema.model.endDate),
      },
    }),
    idCampaingTypePk: (): FieldComponent => ({
      is: Component.Render,
    }),
  }
}
