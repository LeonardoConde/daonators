/**
 * List Schema of AuthResponse
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {AuthResponse} from '@/model/response/AuthResponse'

/* TODO: review generated schema */
export class ListAuthResponseSchema extends DefaultSchema {
  readonly name = 'ListAuthResponse'

  readonly fieldSet: FieldSet<AuthResponse> = {
    token: (): FieldComponent => ({
      is: Component.Render,
    }),
    authAdm: (schema): FieldComponent => ({
      is: Component.Render,
      bind: {
        content: schema.model.authAdm?.$tag,
      },
    }),
  }
}
