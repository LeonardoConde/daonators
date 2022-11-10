<template>
  <div class="navbar bg-primary">
    <div class="container">
      <div class="flex justify-between w-full">
        <div class="flex items-center px-2 w-full">
          <!-- logo -->
          <router-link to="/">
            <div class="navbar__logo">
              <img src="@/assets/img/logo.png" class="h-16" />
              <span class="m-2"> {{ $t('navbar.daonators') }} </span>
            </div>
          </router-link>
          <!-- menu -->
          <div class="navbar__menu">
            <router-link
              v-for="(item, i) in itens"
              :key="i"
              :to="item.path"
              class="navbar__itens hover:text-black"
            >
              {{ item.name }}
            </router-link>
          </div>
          <!-- walletConnect -->
          <button class="navbar__walletConnect hover:text-black ">
            <div class="self-end">
              {{ $t('navbar.walletConnect') }}
            </div>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import {NavItem} from '@/model/NavItem'

@Component
export default class Navbar extends Vue {
  itens: NavItem[] = (this.$t('navbar.itens') as unknown) as NavItem[]
}
</script>

<style lang="scss" scoped>
.navbar {
  @apply shadow-lg;
  &__logo {
    @apply flex items-center py-2 px-5 font-bold text-3xl;
  }
  &__menu {
    @apply hidden horiz w-full justify-end;
  }
  &__itens {
    @apply text-sm mr-10 capitalize text-lg text-white;
  }
  &__walletConnect {
    @apply hidden flex items-end py-3 px-4 rounded-3xl border-2 border-black text-lg  bg-secondary;
  }
}
</style>
