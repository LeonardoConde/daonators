<template>
  <div class="bg-black-50 min-h-screen">
    <navbar />
    <div class="min-h-screen font-bold">
      <h1 class="text-center text-4xl">Votações</h1>
      <voting-grid />
    </div>
    <footer-menu />
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import Navbar from '@/components/navbar/Navbar.vue'
import FooterMenu from '@/components/footer/FooterMenu.vue'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
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
<style scoped></style>
