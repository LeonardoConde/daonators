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
import HomeView from '@/views/home/HomeView.vue'

/**
 * VUE Router Configuration
 */
export class RouterConfig implements RouterOptions {
  readonly mode = 'history'

  readonly routes = [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {path: '*', redirect: '/'},
  ]
}
