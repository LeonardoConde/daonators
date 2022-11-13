/**
 * AuthAdm
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseExclude} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {AuthAdmCollection} from '@/model/collection/AuthAdmCollection'

/* TODO: review generated class */
export class AuthAdm implements IResource {
  idAuthAdmPk: number = 0

  name: string | null = null
  email: string | null = null

  @ResponseExclude()
  password: string | null = null

  get $id() {
    return this.idAuthAdmPk
  }
  set $id(val) {
    this.idAuthAdmPk = val
  }
  get $tag() {
    return String(this.name)
  }

  /**
   * Lists the instances of AuthAdm
   */
  static async listAuthAdm(params: any) {
    return await Request.get(`/client/auth-adm`, {params})
      .name('listAuthAdm')
      .as(AuthAdmCollection)
      .getData()
  }

  /**
   * Persists a new instance of AuthAdm. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistAuthAdm() {
    return await Request.post(`/client/auth-adm`, this)
      .name('persistAuthAdm')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of AuthAdm to export as a file
   */
  static async listExportAuthAdm(params: any) {
    return await Request.get(`/client/auth-adm/export`, {params})
      .name('listExportAuthAdm')
      .as(AuthAdmCollection)
      .getData()
  }

  /**
   * Gets a instance of a given ID of AuthAdm
   */
  async getAuthAdm(id: number) {
    return await Request.get(`/client/auth-adm/${id}`)
      .name('getAuthAdm')
      .as(this)
      .getData()
  }
}
