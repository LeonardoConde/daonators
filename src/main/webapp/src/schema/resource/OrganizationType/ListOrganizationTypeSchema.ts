/**
 * List Schema of OrganizationType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {OrganizationType} from '@/model/resource/OrganizationType'

/* TODO: review generated schema */
export class ListOrganizationTypeSchema extends DefaultSchema {
  readonly name = 'ListOrganizationType'

  readonly fieldSet: FieldSet<OrganizationType> = {
    idOrganizationTypePk: (): FieldComponent => ({
      is: Component.Render,
    }),
    name: (): FieldComponent => ({
      is: Component.Render,
    }),
    active: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: $.filter.bool(schema.model.active),
      },
    }),
  }
}
