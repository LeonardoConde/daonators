/**
 * DonationCollection
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
import {Donation} from '@/model/resource/Donation'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'

/* TODO: review generated class */
@HttpExclude()
export class DonationCollection extends PageCollection<Donation> {
  constructor() {
    super(Donation)
  }

  resource?: IDonationCollectionResourcesHolder

  @RequestExpose() minGasAmount: number | null = null
  @RequestExpose() maxGasAmount: number | null = null

  queryAsPage() {
    return this.listDonation()
  }

  async listDonation() {
    return await Request.get(`/client/donation`, {params: this.params})
      .name('listDonation')
      .as(this)
      .getResponse()
  }

  async listExportDonation() {
    return await Request.get(`/client/donation/export`, {params: this.params})
      .name('listExportDonation')
      .as(this)
      .getResponse()
  }
}

export interface IDonationCollectionResourcesHolder {
  collectionCampaing: CampaingCollection
  collectionOrganization: OrganizationCollection
}
