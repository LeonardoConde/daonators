/**
 * CampaingType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {CampaingTypeCollection} from '@/model/collection/CampaingTypeCollection'

/* TODO: review generated class */
export class CampaingType implements IResource {
  idCampaingTypePk: number = 0

  active: boolean | null = null

  name: string | null = null

  get $id() {
    return this.idCampaingTypePk
  }
  set $id(val) {
    this.idCampaingTypePk = val
  }
  get $tag() {
    return String(this.name)
  }

  /**
   * Lists the instances of CampaingType
   */
  static async listCampaingType(params: any) {
    return await Request.get(`/client/campaing-type`, {params})
      .name('listCampaingType')
      .as(CampaingTypeCollection)
      .getData()
  }

  /**
   * Persists a new instance of CampaingType. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistCampaingType() {
    return await Request.post(`/client/campaing-type`, this)
      .name('persistCampaingType')
      .asNumber()
      .getData()
  }

  /**
   * Gets a instance of a given ID of CampaingType
   */
  async getCampaingType(id: number) {
    return await Request.get(`/client/campaing-type/${id}`)
      .name('getCampaingType')
      .as(this)
      .getData()
  }

  /**
   * Deletes a instance of a given ID of CampaingType
   */
  async removeCampaingType() {
    return await Request.delete(`/client/campaing-type/${this.$id}`)
      .name('removeCampaingType')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of CampaingType to export as a file
   */
  static async listExportCampaingType(params: any) {
    return await Request.get(`/client/campaing-type/export`, {params})
      .name('listExportCampaingType')
      .as(CampaingTypeCollection)
      .getData()
  }
}
