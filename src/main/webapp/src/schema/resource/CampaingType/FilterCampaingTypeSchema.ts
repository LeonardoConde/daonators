/**
 * Filter Schema of CampaingType
 * @author Simpli CLI generator
 */
import {DefaultSchema} from '@/schema/DefaultSchema'
import {FieldSet, FieldComponent} from '@simpli/meta-schema'
import * as Component from '@simpli/vue-input'
import {ICampaingTypeCollectionResourcesHolder} from '@/model/collection/CampaingTypeCollection'
import {CampaingType} from '@/model/resource/CampaingType'

/* TODO: review generated schema */
export class FilterCampaingTypeSchema extends DefaultSchema
  implements ICampaingTypeCollectionResourcesHolder {
  readonly name = 'FilterCampaingType'

  readonly fieldSet: FieldSet<CampaingType> = {}
}
