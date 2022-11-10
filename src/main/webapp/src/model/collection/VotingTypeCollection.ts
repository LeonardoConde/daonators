/**
 * VotingTypeCollection
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
import {VotingType} from '@/model/resource/VotingType'

/* TODO: review generated class */
@HttpExclude()
export class VotingTypeCollection extends PageCollection<VotingType> {
  constructor() {
    super(VotingType)
  }

  resource?: IVotingTypeCollectionResourcesHolder

  queryAsPage() {
    return this.listVotingType()
  }

  async listVotingType() {
    return await Request.get(`/client/voting-type`, {params: this.params})
      .name('listVotingType')
      .as(this)
      .getResponse()
  }

  async listExportVotingType() {
    return await Request.get(`/client/voting-type/export`, {
      params: this.params,
    })
      .name('listExportVotingType')
      .as(this)
      .getResponse()
  }
}

export interface IVotingTypeCollectionResourcesHolder {}
