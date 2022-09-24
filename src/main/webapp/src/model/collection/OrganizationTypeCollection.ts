/**
 * OrganizationTypeCollection
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
import {OrganizationType} from '@/model/resource/OrganizationType'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated class */
@HttpExclude()
export class OrganizationTypeCollection extends PageCollection<
  OrganizationType
> {
  constructor() {
    super(OrganizationType)
  }

  resource?: IOrganizationTypeCollectionResourcesHolder

  queryAsPage() {
    return this.listOrganizationType()
  }

  async listOrganizationType() {
    return await Request.get(`/client/organization-type`, {params: this.params})
      .name('listOrganizationType')
      .as(this)
      .getResponse()
  }

  async listExportOrganizationType() {
    return await Request.get(`/client/organization-type/export`, {
      params: this.params,
    })
      .name('listExportOrganizationType')
      .as(this)
      .getResponse()
  }
}

export interface IOrganizationTypeCollectionResourcesHolder {
  collectionOrganization: OrganizationCollection
}
