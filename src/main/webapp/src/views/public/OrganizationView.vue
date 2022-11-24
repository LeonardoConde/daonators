<template>
  <div class="bg-black-50 h-screen">
    <navbar />
    <div class="h-screen">
      <orgs-grid />
    </div>
    <footer-menu />
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import Navbar from '@/components/navbar/Navbar.vue'
import FooterMenu from '@/components/footer/FooterMenu.vue'
import VotingGrid from '@/components/voting/VotingGrid.vue'
import OrgsGrid from '@/components/orgs/OrgsGrid.vue'

@Component({
  components: {
    OrgsGrid,
    VotingGrid,
    Navbar,
    FooterMenu,
  },
})
export default class OrganizationView extends Vue {}
</script>

<style lang="scss" scoped></style>
