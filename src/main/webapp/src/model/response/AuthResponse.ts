/**
 * AuthResponse
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {User} from '@/model/resource/User'

/* TODO: review generated class */
export class AuthResponse {
  @ResponseSerialize(User)
  user: User | null = null

  token: string | null = null
}
