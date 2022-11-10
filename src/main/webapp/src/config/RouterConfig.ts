/**
 * @file
 * Router Configuration
 * Used in library: vue-router
 *
 * Use this file to register the App routes
 * See https://router.vuejs.org/guide/#javascript
 * This configuration will be set in @/app/Setup.ts
 */

import {RouterOptions} from 'vue-router/types/router'
import HomeView from '@/views/HomeView.vue'
import VotingView from '@/views/VotingView.vue'
import ListCampaingView from '@/views/list/ListCampaingView.vue'

/**
 * VUE Router Configuration
 */
export class RouterConfig implements RouterOptions {
  readonly mode = 'history'

  // @ts-ignore
  readonly routes = [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },

    {
      path: '/voting',
      name: 'voting',
      component: VotingView,
    },
    {
      path: '/test',
      name: 'test',
      component: ListCampaingView,
    },
    {path: '*', redirect: '/'},
  ]
}
