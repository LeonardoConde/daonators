/**
 * Organization
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {OrganizationType} from '@/model/resource/OrganizationType'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated class */
export class Organization implements IResource {
  idOrganizationPk: number = 0

  @ResponseSerialize(OrganizationType)
  organizationTypeList: OrganizationType[] | null = null

  name: string | null = null
  walletAddress: string | null = null
  active: boolean | null = null

  get $id() {
    return this.idOrganizationPk
  }
  set $id(val) {
    this.idOrganizationPk = val
  }
  get $tag() {
    return String(this.name)
  }

  /**
   * Lists the instances of Organization
   */
  static async listOrganization(params: any) {
    return await Request.get(`/client/organization`, {params})
      .name('listOrganization')
      .as(OrganizationCollection)
      .getData()
  }

  /**
   * Persists a new instance of Organization. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistOrganization() {
    return await Request.post(`/client/organization`, this)
      .name('persistOrganization')
      .asNumber()
      .getData()
  }

  /**
   * Gets a instance of a given ID of Organization
   */
  async getOrganization(id: number) {
    return await Request.get(`/client/organization/${id}`)
      .name('getOrganization')
      .as(this)
      .getData()
  }

  /**
   * Deletes a instance of a given ID of Organization
   */
  async removeOrganization() {
    return await Request.delete(`/client/organization/${this.$id}`)
      .name('removeOrganization')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of Organization to export as a file
   */
  static async listExportOrganization(params: any) {
    return await Request.get(`/client/organization/export`, {params})
      .name('listExportOrganization')
      .as(OrganizationCollection)
      .getData()
  }
}
