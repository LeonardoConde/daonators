/**
 * List Schema of User
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldComponent, FieldSet} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-render-schema'
import {User} from '@/model/resource/User'

/* TODO: review generated schema */
export class ListUserSchema extends DefaultSchema {
  readonly name = 'ListUser'

  readonly fieldSet: FieldSet<User> = {
    idUser: (): FieldComponent => ({
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
