<template>
  <div class="bg-black-50 h-screen">
    <navbar />
    <div class="h-screen"></div>
    <footer-menu />
  </div>
</template>

<script lang="ts">
import {Component, Prop, Watch, Mixins, Vue} from 'vue-property-decorator'
import {MixinScreenSize} from '@/components/mixins/MixinScreenSize'
import Navbar from '@/components/navbar/Navbar.vue'
import FooterMenu from '@/components/footer/FooterMenu.vue'

@Component({
  components: {
    Navbar,
    FooterMenu,
  },
})
export default class HomeView extends Vue {}
</script>

<style lang="scss" scoped></style>
