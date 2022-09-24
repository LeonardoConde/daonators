/**
 * UserWallet
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {User} from '@/model/resource/User'
import {UserWalletCollection} from '@/model/collection/UserWalletCollection'

/* TODO: review generated class */
export class UserWallet implements IResource {
  idUserWalletPk: number = 0

  @ResponseSerialize(User)
  user: User | null = null

  walletAddress: string | null = null

  get $id() {
    return this.idUserWalletPk
  }
  set $id(val) {
    this.idUserWalletPk = val
  }
  get $tag() {
    return String(this.$id)
  }

  get idUserFk() {
    if (!this.user) return 0
    return this.user.$id
  }
  set idUserFk(val) {
    if (!this.user) this.user = new User()
    this.user.$id = val
  }

  /**
   * Lists the instances of UserWallet
   */
  static async listUserWallet(params: any) {
    return await Request.get(`/client/user-wallet`, {params})
      .name('listUserWallet')
      .as(UserWalletCollection)
      .getData()
  }

  /**
   * Persists a new instance of UserWallet. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistUserWallet() {
    return await Request.post(`/client/user-wallet`, this)
      .name('persistUserWallet')
      .asNumber()
      .getData()
  }

  /**
   * Gets a instance of a given ID of UserWallet
   */
  async getUserWallet(id: number) {
    return await Request.get(`/client/user-wallet/${id}`)
      .name('getUserWallet')
      .as(this)
      .getData()
  }

  /**
   * Lists the instances of UserWallet to export as a file
   */
  static async listExportUserWallet(params: any) {
    return await Request.get(`/client/user-wallet/export`, {params})
      .name('listExportUserWallet')
      .as(UserWalletCollection)
      .getData()
  }
}
