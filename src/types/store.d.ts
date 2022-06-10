import {User} from '@/model/resource/User'
import {Lang} from '@/enums/Lang'
import {Currency} from '@/enums/Currency'

/**
 * Root
 */
export interface RootState {
  version: string
  language: Lang | null
  currency: Currency | null
}

/**
 * Auth Module
 */
export interface AuthState {
  token: string | null
  user: User | null
  cachePath: string | null
}
