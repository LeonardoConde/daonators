<template>
  <div class="bg-black-50 h-screen">
    <navbar />
    <div class="h-screen">
      <VotingGrid />
    </div>
    <footer-menu />
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import Navbar from '@/components/navbar/Navbar.vue'
import FooterMenu from '@/components/footer/FooterMenu.vue'
import VotingGrid from '@/components/voting/VotingGrid.vue'

@Component({
  components: {
    VotingGrid,
    Navbar,
    FooterMenu,
  },
})
export default class VotingView extends Vue {}
</script>

<style lang="scss" scoped></style>
