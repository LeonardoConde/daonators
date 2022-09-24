/**
 * Export Schema of OrganizationType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet} from '@simpli/meta-schema'
import {OrganizationType} from '@/model/resource/OrganizationType'

/* TODO: review generated schema */
export class ExportOrganizationTypeSchema extends DefaultSchema {
  readonly name = 'ExportOrganizationType'

  readonly fieldSet: FieldSet<OrganizationType> = {
    idOrganizationTypePk: schema => schema.model.idOrganizationTypePk,
    name: schema => schema.model.name,
    active: schema => $.filter.bool(schema.model.active),
  }
}
