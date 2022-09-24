/**
 * VoteCollection
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
import {Vote} from '@/model/resource/Vote'
import {CampaingOrganizationCollection} from '@/model/collection/CampaingOrganizationCollection'
import {UserWalletCollection} from '@/model/collection/UserWalletCollection'

/* TODO: review generated class */
@HttpExclude()
export class VoteCollection extends PageCollection<Vote> {
  constructor() {
    super(Vote)
  }

  resource?: IVoteCollectionResourcesHolder

  @RequestExpose() idCampaingFk: number[] = []
  @RequestExpose() idUserWalletFk: number[] = []
  @RequestExpose() startLastUpdate: string | null = null
  @RequestExpose() endLastUpdate: string | null = null
  @RequestExpose() minIdOrganizationFk: number | null = null
  @RequestExpose() maxIdOrganizationFk: number | null = null

  get campaingOrganization() {
    return (
      this.resource?.collectionCampaingOrganization.getManyIds(
        this.idCampaingFk
      ) ?? null
    )
  }
  set campaingOrganization(input) {
    this.idCampaingFk = input?.map(item => item?.$id) ?? []
  }

  get userWallet() {
    return (
      this.resource?.collectionUserWallet.getManyIds(this.idUserWalletFk) ??
      null
    )
  }
  set userWallet(input) {
    this.idUserWalletFk = input?.map(item => item?.$id) ?? []
  }

  queryAsPage() {
    return this.listExportVote()
  }

  async listExportVote() {
    return await Request.get(`/client/vote/export`, {params: this.params})
      .name('listExportVote')
      .as(this)
      .getResponse()
  }

  async listVote() {
    return await Request.get(`/client/vote`, {params: this.params})
      .name('listVote')
      .as(this)
      .getResponse()
  }
}

export interface IVoteCollectionResourcesHolder {
  collectionCampaingOrganization: CampaingOrganizationCollection
  collectionUserWallet: UserWalletCollection
}
