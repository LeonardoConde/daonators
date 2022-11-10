<template>
  <div class="footer-menu">
    <div class="container horiz grid-col-3 w-full">
      <!-- logo -->
      <div class="weight-1">
        <router-link to="/">
          <div class="footer-menu__logo">
            <img src="@/assets/img/logo.png" class="h-20" />

            <span class="m-2"> {{ $t('footerMenu.daonators') }} </span>
          </div>
        </router-link>
      </div>
      <!-- email -->
      <div class="footer-menu__email weight-1 verti">
        <div class="mb-2">Entre em contato com nós:</div>
        <a :href="$t('app.mailto')" class="text-blue-500">
          {{ $t('app.email') }}
        </a>
      </div>
      <!-- topicos -->
      <div class="verti items-center weight-1">
        <router-link
          v-for="(item, i) in itens"
          :key="i"
          :to="item.path"
          class="footer-menu__topicos hover:text-black"
        >
          {{ item.name }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import {NavItem} from '@/model/NavItem'

@Component
export default class FooterMenu extends Vue {
  itens: NavItem[] = (this.$t('navbar.itens') as unknown) as NavItem[]
}
</script>

<style lang="scss" scoped>
.footer-menu {
  @apply shadow-lg bg-gray-200 py-3;
  &__logo {
    @apply flex items-center py-2 px-5 font-bold text-4xl;
  }
  &__email {
    @apply text-xl my-4 items-center;
  }
  &__topicos {
    @apply text-sm capitalize text-xl items-center m-2;
  }
}
</style>
