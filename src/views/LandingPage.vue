<template>
  <div class="h-screen w-screen bg-gray-800 verti">
    <Navbar />
    aaaaaaa
  </div>
</template>

<script lang="ts">
import {Component, Mixins} from 'vue-property-decorator'
import {MixinScreenSize} from '@/components/mixins/MixinScreenSize'
import Navbar from '@/components/Navbar.vue'

@Component({components: {Navbar}})
export default class LandingPage extends Mixins(MixinScreenSize) {
  poha = false
}
</script>

<style lang="scss"></style>
