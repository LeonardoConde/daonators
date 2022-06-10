import {auth, store} from '@/store'
import {AccessorWrapper} from '@simpli/vuex-typescript'
import {AuthState, RootState} from '@/types/store'
import {AuthRequest} from '@/model/request/AuthRequest'

export const wrapper = new AccessorWrapper<AuthState, RootState>('auth')

export abstract class Auth {
  static $accessors = wrapper.accessors

  static get isLogged() {
    return Auth.$accessors.read(auth.getters.isLogged)(store)
  }

  static get token() {
    return Auth.$accessors.read(auth.getters.token)(store)
  }

  static get user() {
    return Auth.$accessors.read(auth.getters.user)(store)
  }

  static get cachePath() {
    return Auth.$accessors.read(auth.getters.cachePath)(store)
  }

  static signIn(request: AuthRequest) {
    return Auth.$accessors.dispatch(auth.actions.signIn)(store, request)
  }

  static authenticate() {
    return Auth.$accessors.dispatch(auth.actions.authenticate)(store)
  }

  static signOut() {
    return Auth.$accessors.dispatch(auth.actions.signOut)(store)
  }

  static populateToken() {
    return Auth.$accessors.commit(auth.mutations.POPULATE_TOKEN)(store)
  }
}
