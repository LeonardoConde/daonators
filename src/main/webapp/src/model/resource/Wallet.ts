/**
 * Wallet
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {WalletCollection} from '@/model/collection/WalletCollection'

/* TODO: review generated class */
export class Wallet implements IResource {
  idWalletPk: number = 0

  wallet: string | null = null

  get $id() {
    return this.idWalletPk
  }
  set $id(val) {
    this.idWalletPk = val
  }
  get $tag() {
    return String(this.$id)
  }

  /**
   * Lists the instances of Wallet
   */
  static async listWallet(params: any) {
    return await Request.get(`/client/wallet`, {params})
      .name('listWallet')
      .as(WalletCollection)
      .getData()
  }

  /**
   * Persists a new instance of Wallet. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistWallet() {
    return await Request.post(`/client/wallet`, this)
      .name('persistWallet')
      .asNumber()
      .getData()
  }

  /**
   * Gets a instance of a given ID of Wallet
   */
  async getWallet(id: number) {
    return await Request.get(`/client/wallet/${id}`)
      .name('getWallet')
      .as(this)
      .getData()
  }

  /**
   * Lists the instances of Wallet to export as a file
   */
  static async listExportWallet(params: any) {
    return await Request.get(`/client/wallet/export`, {params})
      .name('listExportWallet')
      .as(WalletCollection)
      .getData()
  }
}
