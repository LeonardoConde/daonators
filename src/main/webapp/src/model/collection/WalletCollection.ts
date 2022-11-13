/**
 * WalletCollection
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
import {Wallet} from '@/model/resource/Wallet'

/* TODO: review generated class */
@HttpExclude()
export class WalletCollection extends PageCollection<Wallet> {
  constructor() {
    super(Wallet)
  }

  resource?: IWalletCollectionResourcesHolder

  queryAsPage() {
    return this.listWallet()
  }

  async listWallet() {
    return await Request.get(`/client/wallet`, {params: this.params})
      .name('listWallet')
      .as(this)
      .getResponse()
  }

  async listExportWallet() {
    return await Request.get(`/client/wallet/export`, {params: this.params})
      .name('listExportWallet')
      .as(this)
      .getResponse()
  }
}

export interface IWalletCollectionResourcesHolder {}
