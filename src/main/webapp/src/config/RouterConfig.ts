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
import ListOrganizationView from '@/views/list/ListOrganizationView.vue'
import ListWalletView from '@/views/list/ListWalletView.vue'
import ListAuthAdmView from '@/views/list/ListAuthAdmView.vue'
import ListVotingView from '@/views/list/ListVotingView.vue'
import ListVotingTypeView from '@/views/list/ListVotingTypeView.vue'
import ListDonationView from '@/views/list/ListDonationView.vue'
import ListUserWalletView from '@/views/list/ListUserWalletView.vue'
import PersistCampaingView from '@/views/persist/PersistCampaingView.vue'
import PersistVoteView from '@/views/persist/PersistVoteView.vue'
import PersistOrganizationView from '@/views/persist/PersistOrganizationView.vue'
import PersistWalletView from '@/views/persist/PersistWalletView.vue'
import PersistAuthAdmView from '@/views/persist/PersistAuthAdmView.vue'
import PersistVotingView from '@/views/persist/PersistVotingView.vue'
import PersistVotingTypeView from '@/views/persist/PersistVotingTypeView.vue'
import PersistDonationView from '@/views/persist/PersistDonationView.vue'
import PersistUserWalletView from '@/views/persist/PersistUserWalletView.vue'
import HomeView from '@/views/public/HomeView.vue'
import VotingView from '@/views/public/VotingView.vue'
import OrganizationView from '@/views/public/OrganizationView.vue'

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
      path: '/organization',
      name: 'organization',
      component: OrganizationView,
    },
    {
      path: '/admin/sign-in',
      name: 'signIn',
      component: SignInView,
    },
    {
      path: '/admin/password/recover',
      name: 'recoverPasswordByMail',
      component: RecoverPasswordByMailView,
    },
    {
      path: '/admin/password/reset/:hash',
      name: 'resetPassword',
      component: ResetPasswordView,
      props: true,
    },
    {
      path: '/admin/dashboard',
      component: DefaultLayout,
      children: [
        {
          path: '/admin/dashboard',
          name: 'dashboard',
          component: DashboardView,
        },

        {
          path: '/admin/campaing/list',
          component: ListCampaingView,
        },
        {
          path: '/admin/campaing/new',
          component: PersistCampaingView,
        },
        {
          path: '/admin/campaing/edit/:id',
          name: 'editCampaing',
          component: PersistCampaingView,
          props: true,
        },

        {
          path: '/admin/vote/list',
          component: ListVoteView,
        },
        {
          path: '/admin/vote/new',
          component: PersistVoteView,
        },
        {
          path: '/admin/vote/edit/:id1/:id2',
          name: 'editVote',
          component: PersistVoteView,
          props: true,
        },

        {
          path: '/admin/organization/list',
          component: ListOrganizationView,
        },
        {
          path: '/admin/organization/new',
          component: PersistOrganizationView,
        },
        {
          path: '/admin/organization/edit/:id',
          name: 'editOrganization',
          component: PersistOrganizationView,
          props: true,
        },

        {
          path: '/admin/wallet/list',
          component: ListWalletView,
        },
        {
          path: '/admin/wallet/new',
          component: PersistWalletView,
        },
        {
          path: '/admin/wallet/edit/:id',
          name: 'editWallet',
          component: PersistWalletView,
          props: true,
        },

        {
          path: '/admin/auth-adm/list',
          component: ListAuthAdmView,
        },
        {
          path: '/admin/auth-adm/new',
          component: PersistAuthAdmView,
        },
        {
          path: '/admin/auth-adm/edit/:id',
          name: 'editAuthAdm',
          component: PersistAuthAdmView,
          props: true,
        },

        {
          path: '/admin/voting/list',
          component: ListVotingView,
        },
        {
          path: '/admin/voting/new',
          component: PersistVotingView,
        },
        {
          path: '/admin/voting/edit/:id1/:id2',
          name: 'editVoting',
          component: PersistVotingView,
          props: true,
        },

        {
          path: '/admin/voting-type/list',
          component: ListVotingTypeView,
        },
        {
          path: '/admin/voting-type/new',
          component: PersistVotingTypeView,
        },
        {
          path: '/admin/voting-type/edit/:id',
          name: 'editVotingType',
          component: PersistVotingTypeView,
          props: true,
        },

        {
          path: '/admin/donation/list',
          component: ListDonationView,
        },
        {
          path: '/admin/donation/new',
          component: PersistDonationView,
        },
        {
          path: '/admin/donation/edit/:id1/:id2/:id3',
          name: 'editDonation',
          component: PersistDonationView,
          props: true,
        },

        {
          path: '/admin/user-wallet/list',
          component: ListUserWalletView,
        },
        {
          path: '/admin/user-wallet/new',
          component: PersistUserWalletView,
        },
        {
          path: '/admin/user-wallet/edit/:id',
          name: 'editUserWallet',
          component: PersistUserWalletView,
          props: true,
        },
        {path: '/admin/*', redirect: '/admin/sign-in'},
      ],
    },
    {path: '*', redirect: '/'},
  ]
}
