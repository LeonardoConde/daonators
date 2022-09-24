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
  idUser: number | null = null

  name: string | null = null
  email: string | null = null

  @ResponseExclude()
  password: string | null = null

  get $id() {
    /* TODO: define the ID */
    return 0
  }
  set $id(val) {
    /* TODO: define the ID */
  }
  get $tag() {
    return String(this.name)
  }

  /**
   * Gets a instance of a given ID of User
   */
  async getUser(id: number) {
    return await Request.get(`/client/user/${id}`)
      .name('getUser')
      .as(this)
      .getData()
  }

  /**
   * Lists the instances of User
   */
  static async listUser(params: any) {
    return await Request.get(`/client/user`, {params})
      .name('listUser')
      .as(UserCollection)
      .getData()
  }

  /**
   * Persists a new instance of User. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistUser() {
    return await Request.post(`/client/user`, this)
      .name('persistUser')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of User to export as a file
   */
  static async listExportUser(params: any) {
    return await Request.get(`/client/user/export`, {params})
      .name('listExportUser')
      .as(UserCollection)
      .getData()
  }
}
