/**
 * Campaing
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {Organization} from '@/model/resource/Organization'
import {CampaingCollection} from '@/model/collection/CampaingCollection'

/* TODO: review generated class */
export class Campaing implements IResource {
  idCampaingPk: number = 0

  @ResponseSerialize(Organization)
  campaingOrganization: Organization[] | null = null

  socialCause: string | null = null
  beginDate: string | null = null
  endDate: string | null = null

  name: string | null = null

  get $id() {
    return this.idCampaingPk
  }
  set $id(val) {
    this.idCampaingPk = val
  }
  get $tag() {
    return String(this.name)
  }

  get formattedEnd() {
    return 0
  }

  /**
   * Gets a instance of a given ID of Campaing
   */
  async getCampaing(id: number) {
    return await Request.get(`/client/campaing/${id}`)
      .name('getCampaing')
      .as(this)
      .getData()
  }

  /**
   * Lists the instances of Campaing to export as a file
   */
  static async listExportCampaing(params: any) {
    return await Request.get(`/client/campaing/export`, {params})
      .name('listExportCampaing')
      .as(CampaingCollection)
      .getData()
  }

  /**
   * Lists the instances of Campaing
   */
  static async listCampaing(params: any) {
    return await Request.get(`/client/campaing`, {params})
      .name('listCampaing')
      .as(CampaingCollection)
      .getData()
  }

  /**
   * Persists a new instance of Campaing. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistCampaing() {
    return await Request.post(`/client/campaing`, this)
      .name('persistCampaing')
      .asNumber()
      .getData()
  }
}
