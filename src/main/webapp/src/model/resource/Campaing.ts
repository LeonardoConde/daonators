/**
 * Campaing
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {CampaingType} from '@/model/resource/CampaingType'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import moment from 'moment'

/* TODO: review generated class */
export class Campaing implements IResource {
  idCampaingPk: number = 0
  idCampaingTypePk: number = 0

  @ResponseSerialize(CampaingType)
  campaingType: CampaingType | null = null

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
    return String(this.$id)
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

  get formattedBegging() {
    const date = moment(this.beginDate)
    return date.isValid() ? date.format($.t('dateFormat.date') as string) : ''
  }

  get formattedEnd() {
    const date = moment(this.endDate)
    return date.isValid() ? date.format($.t('dateFormat.date') as string) : ''
  }
}
