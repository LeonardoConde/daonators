<template>
  <div class="h-16 bg-white w-full place-items-center">
    <div class="container horiz justify-between content-center items-center">
      <router-link class="horiz items-center text-pink-600 text-3xl" to="/home">
        <div class="fa fa-piggy-bank text-5xl" v-if="!isMobile" />
        <div class="ml-2" :class="{'text-lg': isMobile}">
          {{ $t('app.navbar.title') }}
        </div>
      </router-link>
      <div v-for="item in list" v-bind:key="item">
        <NavItem :item="item"></NavItem>
      </div>
      <div class="text-pink-600 text-lg" :class="{'text-xl': !isMobile}">
        <button class="text-white rounded-2xl w-auto bg-pink-600 px-3 py-1">
          Login
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Mixins} from 'vue-property-decorator'
import {MixinScreenSize} from '@/components/mixins/MixinScreenSize'
import {NavItemLink} from '@/model/NavItemLink'
import NavItem from '@/components/navbar/NavItem.vue'
@Component({
  components: {NavItem},
})
export default class Navbar extends Mixins(MixinScreenSize) {
  list = (this.$t('app.navbar.items') as unknown) as NavItemLink[]
}
</script>

<style lang="scss"></style>
