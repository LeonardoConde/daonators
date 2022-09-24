/**
 * Input Schema of Organization
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {Organization} from '@/model/resource/Organization'
import {OrganizationTypeCollection} from '@/model/collection/OrganizationTypeCollection'

/* TODO: review generated schema */
export class InputOrganizationSchema extends DefaultSchema {
  collectionOrganizationType = new OrganizationTypeCollection().noPagination()

  readonly name = 'InputOrganization'

  readonly fieldSet: FieldSet<Organization> = {
    organizationTypeList: (schema): FieldComponent => ({
      is: Component.InputSelect,
      bind: {
        label: this.translateFrom(schema.fieldName),
        items: this.collectionOrganizationType.items,
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
    walletAddress: (schema): FieldComponent => ({
      is: Component.InputText,
      bind: {
        type: 'text',
        maxlength: 34,
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
