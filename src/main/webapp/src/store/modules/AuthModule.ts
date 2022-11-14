import {ActionContext, Module} from 'vuex'
import {AccessorHandler} from '@simpli/vuex-typescript'
import {$} from '@/facade'
import {AuthState, RootState} from '@/types/store'
import {AuthRequest} from '@/model/request/AuthRequest'
import {AuthResponse} from '@/model/response/AuthResponse'

export type AuthContext = ActionContext<AuthState, RootState>

@AccessorHandler
export class AuthModule implements Module<AuthState, RootState> {
  namespaced = true

  state: AuthState = {
    token: null,
    authAdm: null,
    cachePath: null,
  }

  getters = {
    isLogged: (state: AuthState) => Boolean(state.token),
    token: (state: AuthState) => state.token,
    authAdm: (state: AuthState) => state.authAdm,
    cachePath: (state: AuthState) => state.cachePath,
  }

  actions = {
    /**
     * Sign in account
     */
    async signIn(context: AuthContext, request: AuthRequest) {
      const authResponse = await request.signIn()

      if (authResponse.token) localStorage.setItem('token', authResponse.token)

      context.commit('POPULATE_TOKEN')
      context.commit('POPULATE', authResponse)

      const uri =
        context.getters.cachePath && $.route.name !== 'signIn'
          ? context.getters.cachePath
          : '/dashboard'

      $.toast.info('system.info.welcome')
      await $.nav.push(uri)

      context.commit('SET_CACHE_PATH', null)

      return authResponse
    },

    /**
     * Verifies authorization and refresh user info.
     */
    async authenticate(context: AuthContext) {
      context.commit('POPULATE_TOKEN')

      let authResponse
      if (context.getters.token) {
        try {
          authResponse = await AuthRequest.authenticate()
        } catch {
          context.commit('FORGET')
        }
      }

      if (!authResponse) {
        return
      }

      context.commit('POPULATE', authResponse)

      return authResponse
    },

    /**
     * Sign out account
     */
    async signOut(context: AuthContext) {
      context.commit('FORGET')
    },
  }

  mutations = {
    POPULATE_TOKEN(state: AuthState) {
      state.token = localStorage.getItem('token') ?? null
    },

    POPULATE(state: AuthState, response: AuthResponse) {
      state.authAdm = response.authAdm
    },

    FORGET(state: AuthState) {
      state.token = null
      state.authAdm = null

      localStorage.removeItem('token')
    },
  }
}
