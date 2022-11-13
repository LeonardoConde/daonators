/**
 * Vote
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {UserWallet} from '@/model/resource/UserWallet'
import {Voting} from '@/model/resource/Voting'
import {VoteCollection} from '@/model/collection/VoteCollection'

/* TODO: review generated class */
export class Vote implements IResource {
  @ResponseSerialize(UserWallet)
  userWallet: UserWallet | null = null

  @ResponseSerialize(Voting)
  voting: Voting | null = null

  tokenAmount: number | null = null

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

  get idVotingFk() {
    if (!this.voting) return 0
    return this.voting.$id
  }
  set idVotingFk(val) {
    if (!this.voting) this.voting = new Voting()
    this.voting.$id = val
  }

  get idUserWalletFk() {
    if (!this.userWallet) return 0
    return this.userWallet.$id
  }
  set idUserWalletFk(val) {
    if (!this.userWallet) this.userWallet = new UserWallet()
    this.userWallet.$id = val
  }

  /**
   * Gets a instance of a given ID of Vote
   */
  async getVote(id1: number, id2: number) {
    return await Request.get(`/client/vote/${id1}/${id2}`)
      .name('getVote')
      .as(this)
      .getData()
  }

  /**
   * Lists the instances of Vote
   */
  static async listVote(params: any) {
    return await Request.get(`/client/vote`, {params})
      .name('listVote')
      .as(VoteCollection)
      .getData()
  }

  /**
   * Persists a new instance of Vote. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistVote() {
    return await Request.post(`/client/vote`, this)
      .name('persistVote')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of Vote to export as a file
   */
  static async listExportVote(params: any) {
    return await Request.get(`/client/vote/export`, {params})
      .name('listExportVote')
      .as(VoteCollection)
      .getData()
  }
}
