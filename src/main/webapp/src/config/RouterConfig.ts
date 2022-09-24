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

import ListCampaingView from '@/views/list/ListCampaingView.vue'
import ListVoteView from '@/views/list/ListVoteView.vue'
import ListUserView from '@/views/list/ListUserView.vue'
import ListOrganizationView from '@/views/list/ListOrganizationView.vue'
import ListCampaingOrganizationView from '@/views/list/ListCampaingOrganizationView.vue'
import ListOrganizationTypeView from '@/views/list/ListOrganizationTypeView.vue'
import ListCampaingTypeView from '@/views/list/ListCampaingTypeView.vue'
import ListUserWalletView from '@/views/list/ListUserWalletView.vue'
import PersistCampaingView from '@/views/persist/PersistCampaingView.vue'
import PersistVoteView from '@/views/persist/PersistVoteView.vue'
import PersistUserView from '@/views/persist/PersistUserView.vue'
import PersistOrganizationView from '@/views/persist/PersistOrganizationView.vue'
import PersistCampaingOrganizationView from '@/views/persist/PersistCampaingOrganizationView.vue'
import PersistOrganizationTypeView from '@/views/persist/PersistOrganizationTypeView.vue'
import PersistCampaingTypeView from '@/views/persist/PersistCampaingTypeView.vue'
import PersistUserWalletView from '@/views/persist/PersistUserWalletView.vue'

/**
 * VUE Router Configuration
 */
export class RouterConfig implements RouterOptions {
  readonly mode = 'history'

  readonly routes = [
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
          path: '/campaing/list',
          component: ListCampaingView,
        },
        {
          path: '/campaing/new',
          component: PersistCampaingView,
        },
        {
          path: '/campaing/edit/:id',
          name: 'editCampaing',
          component: PersistCampaingView,
          props: true,
        },

        {
          path: '/vote/list',
          component: ListVoteView,
        },
        {
          path: '/vote/new',
          component: PersistVoteView,
        },
        {
          path: '/vote/edit/:id',
          name: 'editVote',
          component: PersistVoteView,
          props: true,
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

        {
          path: '/organization/list',
          component: ListOrganizationView,
        },
        {
          path: '/organization/new',
          component: PersistOrganizationView,
        },
        {
          path: '/organization/edit/:id',
          name: 'editOrganization',
          component: PersistOrganizationView,
          props: true,
        },

        {
          path: '/campaing-organization/list',
          component: ListCampaingOrganizationView,
        },
        {
          path: '/campaing-organization/new',
          component: PersistCampaingOrganizationView,
        },
        {
          path: '/campaing-organization/edit/:id1/:id2',
          name: 'editCampaingOrganization',
          component: PersistCampaingOrganizationView,
          props: true,
        },

        {
          path: '/organization-type/list',
          component: ListOrganizationTypeView,
        },
        {
          path: '/organization-type/new',
          component: PersistOrganizationTypeView,
        },
        {
          path: '/organization-type/edit/:id',
          name: 'editOrganizationType',
          component: PersistOrganizationTypeView,
          props: true,
        },

        {
          path: '/campaing-type/list',
          component: ListCampaingTypeView,
        },
        {
          path: '/campaing-type/new',
          component: PersistCampaingTypeView,
        },
        {
          path: '/campaing-type/edit/:id',
          name: 'editCampaingType',
          component: PersistCampaingTypeView,
          props: true,
        },

        {
          path: '/user-wallet/list',
          component: ListUserWalletView,
        },
        {
          path: '/user-wallet/new',
          component: PersistUserWalletView,
        },
        {
          path: '/user-wallet/edit/:id',
          name: 'editUserWallet',
          component: PersistUserWalletView,
          props: true,
        },
      ],
    },
    {path: '/', redirect: '/sign-in'},
    {path: '*', redirect: '/dashboard'},
  ]
}
