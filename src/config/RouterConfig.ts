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

import DefaultLayout from '@/views/layouts/DefaultLayout.vue'
import DashboardView from '@/views/DashboardView.vue'

import SignInView from '@/views/auth/SignInView.vue'
import RecoverPasswordByMailView from '@/views/auth/RecoverPasswordByMailView.vue'
import ResetPasswordView from '@/views/auth/ResetPasswordView.vue'

import ListUserView from '@/views/list/ListUserView.vue'
import PersistUserView from '@/views/persist/PersistUserView.vue'
import LandingPage from '@/views/LandingPage.vue'

/**
 * VUE Router Configuration
 */
export class RouterConfig implements RouterOptions {
  readonly mode = 'history'

  readonly routes = [
    {
      path: '/home',
      name: 'home',
      component: LandingPage,
    },
    {
      path: '/sign-in',
      name: 'signIn',
      component: SignInView,
    },
    {
      path: '/password/recover',
      name: 'recoverPasswordByMail',
      component: RecoverPasswordByMailView,
    },
    {
      path: '/password/reset/:hash',
      name: 'resetPassword',
      component: ResetPasswordView,
      props: true,
    },
    {
      path: '/dashboard',
      component: DefaultLayout,
      children: [
        {
          path: '/dashboard',
          name: 'dashboard',
          component: DashboardView,
        },

        {
          path: '/user/list',
          component: ListUserView,
        },
        {
          path: '/user/new',
          component: PersistUserView,
        },
        {
          path: '/user/edit/:id',
          name: 'editUser',
          component: PersistUserView,
          props: true,
        },
      ],
    },
    {path: '/', redirect: '/home'},
    {path: '*', redirect: '/home'},
  ]
}
