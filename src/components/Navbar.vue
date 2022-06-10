<template>
  <div class="h-16 bg-white w-full px-5 horiz justify-between items-center">
    <router-link class="horiz items-center text-pink-600 text-3xl" to="/home">
      <div class="fa fa-piggy-bank text-5xl" v-if="!isMobile" />
      <div class="ml-2" :class="{'text-lg': isMobile}">
        {{ $t('app.title') }}
      </div>
    </router-link>
    <div class="text-pink-600 text-lg" :class="{'text-xl': !isMobile}">
      <button class="text-white rounded-2xl w-auto bg-pink-600 px-3 py-1">
        Login
      </button>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Mixins} from 'vue-property-decorator'
import {MixinScreenSize} from '@/components/mixins/MixinScreenSize'

@Component
export default class Navbar extends Mixins(MixinScreenSize) {
  poha = false
}
</script>

<style lang="scss"></style>
