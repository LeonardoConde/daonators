/**
 * CampaingCollection
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
import {Campaing} from '@/model/resource/Campaing'
import {CampaingTypeCollection} from '@/model/collection/CampaingTypeCollection'

/* TODO: review generated class */
@HttpExclude()
export class CampaingCollection extends PageCollection<Campaing> {
  constructor() {
    super(Campaing)
  }

  resource?: ICampaingCollectionResourcesHolder

  @RequestExpose() idCampaingTypePk: number[] = []
  @RequestExpose() startBeginDate: string | null = null
  @RequestExpose() endBeginDate: string | null = null
  @RequestExpose() startEndDate: string | null = null
  @RequestExpose() endEndDate: string | null = null

  queryAsPage() {
    return this.listCampaing()
  }

  async listCampaing() {
    return await Request.get(`/client/campaing`, {params: this.params})
      .name('listCampaing')
      .as(this)
      .getResponse()
  }

  async listExportCampaing() {
    return await Request.get(`/client/campaing/export`, {params: this.params})
      .name('listExportCampaing')
      .as(this)
      .getResponse()
  }
}

export interface ICampaingCollectionResourcesHolder {
  collectionCampaingType: CampaingTypeCollection
}
