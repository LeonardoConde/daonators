/**
 * CampaingOrganizationCollection
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
import {CampaingOrganization} from '@/model/resource/CampaingOrganization'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated class */
@HttpExclude()
export class CampaingOrganizationCollection extends PageCollection<
  CampaingOrganization
> {
  constructor() {
    super(CampaingOrganization)
  }

  resource?: ICampaingOrganizationCollectionResourcesHolder

  @RequestExpose() minGasAmount: number | null = null
  @RequestExpose() maxGasAmount: number | null = null

  queryAsPage() {
    return this.listCampaingOrganization()
  }

  async listCampaingOrganization() {
    return await Request.get(`/client/campaing-organization`, {
      params: this.params,
    })
      .name('listCampaingOrganization')
      .as(this)
      .getResponse()
  }

  async listExportCampaingOrganization() {
    return await Request.get(`/client/campaing-organization/export`, {
      params: this.params,
    })
      .name('listExportCampaingOrganization')
      .as(this)
      .getResponse()
  }
}

export interface ICampaingOrganizationCollectionResourcesHolder {
  collectionCampaing: CampaingCollection
  collectionOrganization: OrganizationCollection
}
