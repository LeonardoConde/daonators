/**
 * OrganizationType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {Organization} from '@/model/resource/Organization'
import {OrganizationTypeCollection} from '@/model/collection/OrganizationTypeCollection'

/* TODO: review generated class */
export class OrganizationType implements IResource {
  idOrganizationTypePk: number = 0

  @ResponseSerialize(Organization)
  organizationTypeList: Organization[] | null = null

  name: string | null = null
  active: boolean | null = null

  get $id() {
    return this.idOrganizationTypePk
  }
  set $id(val) {
    this.idOrganizationTypePk = val
  }
  get $tag() {
    return String(this.name)
  }

  /**
   * Gets a instance of a given ID of OrganizationType
   */
  async getOrganizationType(id: number) {
    return await Request.get(`/client/organization-type/${id}`)
      .name('getOrganizationType')
      .as(this)
      .getData()
  }

  /**
   * Deletes a instance of a given ID of OrganizationType
   */
  async removeOrganizationType() {
    return await Request.delete(`/client/organization-type/${this.$id}`)
      .name('removeOrganizationType')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of OrganizationType
   */
  static async listOrganizationType(params: any) {
    return await Request.get(`/client/organization-type`, {params})
      .name('listOrganizationType')
      .as(OrganizationTypeCollection)
      .getData()
  }

  /**
   * Persists a new instance of OrganizationType. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistOrganizationType() {
    return await Request.post(`/client/organization-type`, this)
      .name('persistOrganizationType')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of OrganizationType to export as a file
   */
  static async listExportOrganizationType(params: any) {
    return await Request.get(`/client/organization-type/export`, {params})
      .name('listExportOrganizationType')
      .as(OrganizationTypeCollection)
      .getData()
  }
}
