/**
 * Voting
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {Campaing} from '@/model/resource/Campaing'
import {Organization} from '@/model/resource/Organization'
import {VotingType} from '@/model/resource/VotingType'
import {VotingCollection} from '@/model/collection/VotingCollection'

/* TODO: review generated class */
export class Voting implements IResource {
  idVotingPk: number = 0

  @ResponseSerialize(Campaing)
  campaing: Campaing | null = null

  @ResponseSerialize(Organization)
  organization: Organization | null = null

  @ResponseSerialize(VotingType)
  votingType: VotingType | null = null

  idOrganizationfk: number | null = null

  get $id() {
    return this.idVotingPk
  }
  set $id(val) {
    this.idVotingPk = val
  }
  get $tag() {
    return String(this.$id)
  }

  get idVotingTypeFk() {
    if (!this.votingType) return 0
    return this.votingType.$id
  }
  set idVotingTypeFk(val) {
    if (!this.votingType) this.votingType = new VotingType()
    this.votingType.$id = val
  }

  get idCampaingFk() {
    if (!this.campaing) return 0
    return this.campaing.$id
  }
  set idCampaingFk(val) {
    if (!this.campaing) this.campaing = new Campaing()
    this.campaing.$id = val
  }

  /**
   * Gets a instance of a given ID of Voting
   */
  async getVoting(id1: number, id2: number) {
    return await Request.get(`/client/voting/${id1}/${id2}`)
      .name('getVoting')
      .as(this)
      .getData()
  }

  /**
   * Lists the instances of Voting
   */
  static async listVoting(params: any) {
    return await Request.get(`/client/voting`, {params})
      .name('listVoting')
      .as(VotingCollection)
      .getData()
  }

  /**
   * Persists a new instance of Voting. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistVoting() {
    return await Request.post(`/client/voting`, this)
      .name('persistVoting')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of Voting to export as a file
   */
  static async listExportVoting(params: any) {
    return await Request.get(`/client/voting/export`, {params})
      .name('listExportVoting')
      .as(VotingCollection)
      .getData()
  }
}
