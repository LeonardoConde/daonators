/**
 * AuthResponse
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {AuthAdm} from '@/model/resource/AuthAdm'

/* TODO: review generated class */
export class AuthResponse {
  @ResponseSerialize(AuthAdm)
  authAdm: AuthAdm | null = null

  token: string | null = null
}
