/**
 * List Schema of AuthAdm
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {AuthAdm} from '@/model/resource/AuthAdm'

/* TODO: review generated schema */
export class ListAuthAdmSchema extends DefaultSchema {
  readonly name = 'ListAuthAdm'

  readonly fieldSet: FieldSet<AuthAdm> = {
    idAuthAdmPk: (): FieldComponent => ({
      is: Component.Render,
    }),
    name: (): FieldComponent => ({
      is: Component.Render,
    }),
    email: (): FieldComponent => ({
      is: Component.Render,
    }),
  }
}
