<template>
  <div class="h-screen w-screen verti">
    <Navbar />
    {{ $t('app.title') }}
  </div>
</template>

<script lang="ts">
import {Component, Mixins} from 'vue-property-decorator'
import {MixinScreenSize} from '@/components/mixins/MixinScreenSize'
import Navbar from '@/components/navbar/Navbar.vue'

@Component({components: {Navbar}})
export default class LandingPage extends Mixins(MixinScreenSize) {
  poha = false
}
</script>

<style lang="scss"></style>
