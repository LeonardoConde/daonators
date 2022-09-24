/**
 * CampaingOrganization
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {Campaing} from '@/model/resource/Campaing'
import {Organization} from '@/model/resource/Organization'
import {CampaingOrganizationCollection} from '@/model/collection/CampaingOrganizationCollection'

/* TODO: review generated class */
export class CampaingOrganization implements IResource {
  @ResponseSerialize(Campaing)
  campaing: Campaing | null = null

  @ResponseSerialize(Organization)
  organization: Organization | null = null

  transactionHash: string | null = null
  gasAmount: number | null = null

  get $id() {
    /* TODO: define the ID */
    return 0
  }
  set $id(val) {
    /* TODO: define the ID */
  }
  get $tag() {
    return String(this.$id)
  }

  get idCampaingFk() {
    if (!this.campaing) return 0
    return this.campaing.$id
  }
  set idCampaingFk(val) {
    if (!this.campaing) this.campaing = new Campaing()
    this.campaing.$id = val
  }

  get idOrganizationFk() {
    if (!this.organization) return 0
    return this.organization.$id
  }
  set idOrganizationFk(val) {
    if (!this.organization) this.organization = new Organization()
    this.organization.$id = val
  }

  /**
   * Gets a instance of a given ID of CampaingOrganization
   */
  async getCampaingOrganization(id1: number, id2: number) {
    return await Request.get(`/client/campaing-organization/${id1}/${id2}`)
      .name('getCampaingOrganization')
      .as(this)
      .getData()
  }

  /**
   * Lists the instances of CampaingOrganization
   */
  static async listCampaingOrganization(params: any) {
    return await Request.get(`/client/campaing-organization`, {params})
      .name('listCampaingOrganization')
      .as(CampaingOrganizationCollection)
      .getData()
  }

  /**
   * Persists a new instance of CampaingOrganization. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistCampaingOrganization() {
    return await Request.post(`/client/campaing-organization`, this)
      .name('persistCampaingOrganization')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of CampaingOrganization to export as a file
   */
  static async listExportCampaingOrganization(params: any) {
    return await Request.get(`/client/campaing-organization/export`, {params})
      .name('listExportCampaingOrganization')
      .as(CampaingOrganizationCollection)
      .getData()
  }
}
