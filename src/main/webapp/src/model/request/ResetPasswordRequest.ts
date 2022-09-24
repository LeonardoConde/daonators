/**
 * ResetPasswordRequest
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseExclude} from '@simpli/serialized-request'

/* TODO: review generated class */
export class ResetPasswordRequest {
  hash: string | null = null

  @ResponseExclude()
  newPassword: string | null = null

  @ResponseExclude()
  confirmPassword: string | null = null

  /**
   * Recovers the password with a given hash
   */
  async resetPassword() {
    const request = $.utils.clone(this)
    request.newPassword = $.utils.sha256(this.newPassword)
    request.confirmPassword = $.utils.sha256(this.confirmPassword)

    return await Request.post(`/client/auth/password`, request)
      .name('resetPassword')
      .asString()
      .getData()
  }
}
