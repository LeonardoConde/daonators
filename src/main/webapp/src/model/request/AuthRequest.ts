/**
 * AuthRequest
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseExclude} from '@simpli/serialized-request'
import {AuthResponse} from '@/model/response/AuthResponse'

/* TODO: review generated class */
export class AuthRequest {
  email: string | null = null

  @ResponseExclude()
  password: string | null = null

  /**
   * Gets the user authentication
   */
  static async authenticate() {
    return await Request.get(`/client/auth`)
      .name('authenticate')
      .as(AuthResponse)
      .getData()
  }

  /**
   * Submits the user authentication
   */
  async signIn() {
    const request = $.utils.clone(this)
    request.password = $.utils.sha256(this.password)

    return await Request.post(`/client/auth`, request)
      .name('signIn')
      .delay(1000)
      .as(AuthResponse)
      .getData()
  }
}
