/**
 * List Schema of CampaingType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {CampaingType} from '@/model/resource/CampaingType'

/* TODO: review generated schema */
export class ListCampaingTypeSchema extends DefaultSchema {
  readonly name = 'ListCampaingType'

  readonly fieldSet: FieldSet<CampaingType> = {
    idCampaingTypePk: (): FieldComponent => ({
      is: Component.Render,
    }),
    active: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: $.filter.bool(schema.model.active),
      },
    }),
    name: (): FieldComponent => ({
      is: Component.Render,
    }),
  }
}
