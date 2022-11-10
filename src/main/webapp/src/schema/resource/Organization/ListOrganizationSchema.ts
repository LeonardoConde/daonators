/**
 * List Schema of Organization
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {Organization} from '@/model/resource/Organization'

/* TODO: review generated schema */
export class ListOrganizationSchema extends DefaultSchema {
  readonly name = 'ListOrganization'

  readonly fieldSet: FieldSet<Organization> = {
    idOrganizationPk: (): FieldComponent => ({
      is: Component.Render,
    }),
    name: (): FieldComponent => ({
      is: Component.Render,
    }),
    scriptHash: (): FieldComponent => ({
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
