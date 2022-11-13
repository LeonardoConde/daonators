/**
 * Export Schema of AuthAdm
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {AuthAdm} from '@/model/resource/AuthAdm'

/* TODO: review generated schema */
export class ExportAuthAdmSchema extends DefaultSchema {
  readonly name = 'ExportAuthAdm'

  readonly fieldSet: FieldSet<AuthAdm> = {
    idAuthAdmPk: schema => schema.model.idAuthAdmPk,
    name: schema => schema.model.name,
    email: schema => schema.model.email,
  }
}
