/**
 * Export Schema of Organization
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {Organization} from '@/model/resource/Organization'

/* TODO: review generated schema */
export class ExportOrganizationSchema extends DefaultSchema {
  readonly name = 'ExportOrganization'

  readonly fieldSet: FieldSet<Organization> = {
    idOrganizationPk: schema => schema.model.idOrganizationPk,
    name: schema => schema.model.name,
    scriptHash: schema => schema.model.scriptHash,
    active: schema => $.filter.bool(schema.model.active),
  }
}
