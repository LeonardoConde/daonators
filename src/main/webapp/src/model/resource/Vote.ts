/**
 * Vote
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {CampaingOrganization} from '@/model/resource/CampaingOrganization'
import {UserWallet} from '@/model/resource/UserWallet'
import {VoteCollection} from '@/model/collection/VoteCollection'

/* TODO: review generated class */
export class Vote implements IResource {
  idVotePk: number = 0

  @ResponseSerialize(CampaingOrganization)
  campaingOrganization: CampaingOrganization | null = null

  @ResponseSerialize(UserWallet)
  userWallet: UserWallet | null = null

  lastUpdate: string | null = null
  tokensAmount: string | null = null
  idOrganizationFk: number | null = null
  idCampaingFk: number | null = null

  get $id() {
    return this.idVotePk
  }
  set $id(val) {
    this.idVotePk = val
  }
  get $tag() {
    return String(this.$id)
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
  async getVote(id: number) {
    return await Request.get(`/client/vote/${id}`)
      .name('getVote')
      .as(this)
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
}
