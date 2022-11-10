/**
 * AuthAdmCollection
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
import {AuthAdm} from '@/model/resource/AuthAdm'

/* TODO: review generated class */
@HttpExclude()
export class AuthAdmCollection extends PageCollection<AuthAdm> {
  constructor() {
    super(AuthAdm)
  }

  resource?: IAuthAdmCollectionResourcesHolder

  queryAsPage() {
    return this.listAuthAdm()
  }

  async listAuthAdm() {
    return await Request.get(`/client/auth-adm`, {params: this.params})
      .name('listAuthAdm')
      .as(this)
      .getResponse()
  }

  async listExportAuthAdm() {
    return await Request.get(`/client/auth-adm/export`, {params: this.params})
      .name('listExportAuthAdm')
      .as(this)
      .getResponse()
  }
}

export interface IAuthAdmCollectionResourcesHolder {}
