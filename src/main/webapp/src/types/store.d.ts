import {AuthAdm} from '@/model/resource/AuthAdm'
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
  authAdm: AuthAdm | null
  cachePath: string | null
}
