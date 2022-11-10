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
import {UserWalletCollection} from '@/model/collection/UserWalletCollection'
import {VotingCollection} from '@/model/collection/VotingCollection'

/* TODO: review generated class */
@HttpExclude()
export class VoteCollection extends PageCollection<Vote> {
  constructor() {
    super(Vote)
  }

  resource?: IVoteCollectionResourcesHolder

  @RequestExpose() minTokenAmount: number | null = null
  @RequestExpose() maxTokenAmount: number | null = null

  queryAsPage() {
    return this.listVote()
  }

  async listVote() {
    return await Request.get(`/client/vote`, {params: this.params})
      .name('listVote')
      .as(this)
      .getResponse()
  }

  async listExportVote() {
    return await Request.get(`/client/vote/export`, {params: this.params})
      .name('listExportVote')
      .as(this)
      .getResponse()
  }
}

export interface IVoteCollectionResourcesHolder {
  collectionUserWallet: UserWalletCollection
  collectionVoting: VotingCollection
}
