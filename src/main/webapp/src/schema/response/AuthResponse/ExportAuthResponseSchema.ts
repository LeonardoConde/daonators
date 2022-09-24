/**
 * Export Schema of AuthResponse
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {AuthResponse} from '@/model/response/AuthResponse'

/* TODO: review generated schema */
export class ExportAuthResponseSchema extends DefaultSchema {
  readonly name = 'ExportAuthResponse'

  readonly fieldSet: FieldSet<AuthResponse> = {
    token: schema => schema.model.token,
    user: schema => schema.model.user?.$tag ?? null,
  }
}
