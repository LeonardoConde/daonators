/**
 * ChangePasswordRequest
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseExclude} from '@simpli/serialized-request'

/* TODO: review generated class */
export class ChangePasswordRequest {
  @ResponseExclude()
  currentPassword: string | null = null

  @ResponseExclude()
  newPassword: string | null = null

  @ResponseExclude()
  confirmPassword: string | null = null

  /**
   * Changes the password with a given new password
   */
  async changePassword() {
    const request = $.utils.clone(this)
    request.currentPassword = $.utils.sha256(this.currentPassword)
    request.newPassword = $.utils.sha256(this.newPassword)
    request.confirmPassword = $.utils.sha256(this.confirmPassword)

    return await Request.post(`/client/auth/me/password`, request)
      .name('changePassword')
      .asNumber()
      .getData()
  }
}
