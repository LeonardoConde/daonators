/**
 * UserWalletCollection
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
import {UserWallet} from '@/model/resource/UserWallet'

/* TODO: review generated class */
@HttpExclude()
export class UserWalletCollection extends PageCollection<UserWallet> {
  constructor() {
    super(UserWallet)
  }

  resource?: IUserWalletCollectionResourcesHolder

  queryAsPage() {
    return this.listUserWallet()
  }

  async listUserWallet() {
    return await Request.get(`/client/user-wallet`, {params: this.params})
      .name('listUserWallet')
      .as(this)
      .getResponse()
  }

  async listExportUserWallet() {
    return await Request.get(`/client/user-wallet/export`, {
      params: this.params,
    })
      .name('listExportUserWallet')
      .as(this)
      .getResponse()
  }
}

export interface IUserWalletCollectionResourcesHolder {}
