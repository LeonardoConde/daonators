/**
 * OrganizationCollection
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
import {Organization} from '@/model/resource/Organization'
import {CampaingCollection} from '@/model/collection/CampaingCollection'

/* TODO: review generated class */
@HttpExclude()
export class OrganizationCollection extends PageCollection<Organization> {
  constructor() {
    super(Organization)
  }

  resource?: IOrganizationCollectionResourcesHolder

  queryAsPage() {
    return this.listOrganization()
  }

  async listOrganization() {
    return await Request.get(`/client/organization`, {params: this.params})
      .name('listOrganization')
      .as(this)
      .getResponse()
  }

  async listExportOrganization() {
    return await Request.get(`/client/organization/export`, {
      params: this.params,
    })
      .name('listExportOrganization')
      .as(this)
      .getResponse()
  }
}

export interface IOrganizationCollectionResourcesHolder {
  collectionCampaing: CampaingCollection
}
