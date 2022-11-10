/**
 * VotingType
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {VotingTypeCollection} from '@/model/collection/VotingTypeCollection'

/* TODO: review generated class */
export class VotingType implements IResource {
  idVotingTypePk: number = 0

  name: string | null = null
  active: boolean | null = null

  get $id() {
    return this.idVotingTypePk
  }
  set $id(val) {
    this.idVotingTypePk = val
  }
  get $tag() {
    return String(this.name)
  }

  /**
   * Lists the instances of VotingType
   */
  static async listVotingType(params: any) {
    return await Request.get(`/client/voting-type`, {params})
      .name('listVotingType')
      .as(VotingTypeCollection)
      .getData()
  }

  /**
   * Persists a new instance of VotingType. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistVotingType() {
    return await Request.post(`/client/voting-type`, this)
      .name('persistVotingType')
      .asNumber()
      .getData()
  }

  /**
   * Gets a instance of a given ID of VotingType
   */
  async getVotingType(id: number) {
    return await Request.get(`/client/voting-type/${id}`)
      .name('getVotingType')
      .as(this)
      .getData()
  }

  /**
   * Deletes a instance of a given ID of VotingType
   */
  async removeVotingType() {
    return await Request.delete(`/client/voting-type/${this.$id}`)
      .name('removeVotingType')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of VotingType to export as a file
   */
  static async listExportVotingType(params: any) {
    return await Request.get(`/client/voting-type/export`, {params})
      .name('listExportVotingType')
      .as(VotingTypeCollection)
      .getData()
  }
}
