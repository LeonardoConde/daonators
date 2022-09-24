import Vue from 'vue'
import Vuex, {Store} from 'vuex'
import {RootStore} from '@/store/RootStore'
import {AuthModule} from '@/store/modules/AuthModule'

Vue.use(Vuex)

export const root = new RootStore()
export const auth = new AuthModule()

root.modules = {
  auth,
}

export const store = new Store(root)
