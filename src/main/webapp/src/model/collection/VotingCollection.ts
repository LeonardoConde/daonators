/**
 * VotingCollection
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
import {Voting} from '@/model/resource/Voting'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'
import {VotingTypeCollection} from '@/model/collection/VotingTypeCollection'

/* TODO: review generated class */
@HttpExclude()
export class VotingCollection extends PageCollection<Voting> {
  constructor() {
    super(Voting)
  }

  resource?: IVotingCollectionResourcesHolder

  @RequestExpose() idCampaingFk: number[] = []
  @RequestExpose() idVotingTypeFk: number[] = []

  get votingType() {
    return (
      this.resource?.collectionVotingType.getManyIds(this.idVotingTypeFk) ??
      null
    )
  }
  set votingType(input) {
    this.idVotingTypeFk = input?.map(item => item?.$id) ?? []
  }

  get campaing() {
    return (
      this.resource?.collectionCampaing.getManyIds(this.idCampaingFk) ?? null
    )
  }
  set campaing(input) {
    this.idCampaingFk = input?.map(item => item?.$id) ?? []
  }

  queryAsPage() {
    return this.listVoting()
  }

  async listVoting() {
    return await Request.get(`/client/voting`, {params: this.params})
      .name('listVoting')
      .as(this)
      .getResponse()
  }

  async listExportVoting() {
    return await Request.get(`/client/voting/export`, {params: this.params})
      .name('listExportVoting')
      .as(this)
      .getResponse()
  }
}

export interface IVotingCollectionResourcesHolder {
  collectionCampaing: CampaingCollection
  collectionOrganization: OrganizationCollection
  collectionVotingType: VotingTypeCollection
}
