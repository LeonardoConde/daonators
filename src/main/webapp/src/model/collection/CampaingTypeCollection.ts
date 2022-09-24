/**
 * CampaingTypeCollection
 *
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {
  HttpExclude,
  Request,
  RequestExpose,
  ResponseSerialize,
} from '@simpli/serialized-request'
import {PageCollection} from '@simpli/resource-collection'
import {CampaingType} from '@/model/resource/CampaingType'

/* TODO: review generated class */
@HttpExclude()
export class CampaingTypeCollection extends PageCollection<CampaingType> {
  constructor() {
    super(CampaingType)
  }

  resource?: ICampaingTypeCollectionResourcesHolder

  queryAsPage() {
    return this.listCampaingType()
  }

  async listCampaingType() {
    return await Request.get(`/client/campaing-type`, {params: this.params})
      .name('listCampaingType')
      .as(this)
      .getResponse()
  }

  async listExportCampaingType() {
    return await Request.get(`/client/campaing-type/export`, {
      params: this.params,
    })
      .name('listExportCampaingType')
      .as(this)
      .getResponse()
  }
}

export interface ICampaingTypeCollectionResourcesHolder {}
