/**
 * Export Schema of User
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {User} from '@/model/resource/User'

/* TODO: review generated schema */
export class ExportUserSchema extends DefaultSchema {
  readonly name = 'ExportUser'

  readonly fieldSet: FieldSet<User> = {
    idUser: schema => schema.model.idUser,
    name: schema => schema.model.name,
    email: schema => schema.model.email,
  }
}
