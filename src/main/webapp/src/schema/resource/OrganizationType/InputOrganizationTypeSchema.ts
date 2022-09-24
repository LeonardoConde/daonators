/**
 * Input Schema of OrganizationType
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {OrganizationType} from '@/model/resource/OrganizationType'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated schema */
export class InputOrganizationTypeSchema extends DefaultSchema {
  collectionOrganization = new OrganizationCollection().noPagination()

  readonly name = 'InputOrganizationType'

  readonly fieldSet: FieldSet<OrganizationType> = {
    organizationTypeList: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionOrganization.items,
      },
    }),
    name: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'text',
        maxlength: 45,
        label: this.translateFrom(schema.fieldName),
        required: true,
        validation: 'required',
      },
    }),
    active: (schema): FieldComponent => ({
      is: Component.InputCheckbox,
      bind: {
        label: this.translateFrom(schema.fieldName),
        class: 'pretty p-switch p-fill justify-center mt-8',
        labelClass: 'relative state',
      },
    }),
  }
}
