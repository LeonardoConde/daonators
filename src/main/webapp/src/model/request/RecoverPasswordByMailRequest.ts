/**
 * RecoverPasswordByMailRequest
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request} from '@simpli/serialized-request'

/* TODO: review generated class */
export class RecoverPasswordByMailRequest {
  email: string | null = null

  /**
   * Sends an email requesting to change the password
   */
  async recoverPasswordByMail() {
    return await Request.put(`/client/auth/password`, this)
      .name('recoverPasswordByMail')
      .asNumber()
      .getData()
  }
}
