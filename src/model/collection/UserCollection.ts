/**
 * UserCollection
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
import {User} from '@/model/resource/User'

/* TODO: review generated class */
@HttpExclude()
export class UserCollection extends PageCollection<User> {
  constructor() {
    super(User)
  }

  resource?: IUserCollectionResourcesHolder

  queryAsPage() {
    return this.list()
  }

  async list() {
    return await Request.get(`/admin/user`, {params: this.params})
      .name('list')
      .as(this)
      .getResponse()
  }

  async listCsv() {
    return await Request.get(`/admin/user/csv`, {params: this.params})
      .name('listCsv')
      .as(this)
      .getResponse()
  }
}

export interface IUserCollectionResourcesHolder {}
