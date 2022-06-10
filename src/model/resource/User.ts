/**
 * User
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseExclude} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {UserCollection} from '@/model/collection/UserCollection'

/* TODO: review generated class */
export class User implements IResource {
  idUserPk: number = 0

  email: string | null = null

  @ResponseExclude()
  password: string | null = null

  get $id() {
    return this.idUserPk
  }
  set $id(val) {
    this.idUserPk = val
  }
  get $tag() {
    return String(this.email)
  }

  /**
   * Lists the instances from User
   */
  static async list(params: any) {
    return await Request.get(`/admin/user`, {params})
      .name('list')
      .as(UserCollection)
      .getData()
  }

  /**
   * Persists a new instance from User
   *
   * Use ID = 0 to create a new one, or ID > 0 to update
   * a current one
   */
  async persist() {
    return await Request.post(`/admin/user`, this)
      .name('persist')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances from User to use it in a CSV file
   */
  static async listCsv(params: any) {
    return await Request.get(`/admin/user/csv`, {params})
      .name('listCsv')
      .as(UserCollection)
      .getData()
  }

  /**
   * Gets a instance of a given ID from User
   */
  async populate(id: number) {
    return await Request.get(`/admin/user/${id}`)
      .name('populate')
      .as(this)
      .getData()
  }
}
