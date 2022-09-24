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
    return this.listUser()
  }

  async listUser() {
    return await Request.get(`/client/user`, {params: this.params})
      .name('listUser')
      .as(this)
      .getResponse()
  }

  async listExportUser() {
    return await Request.get(`/client/user/export`, {params: this.params})
      .name('listExportUser')
      .as(this)
      .getResponse()
  }
}

export interface IUserCollectionResourcesHolder {}
