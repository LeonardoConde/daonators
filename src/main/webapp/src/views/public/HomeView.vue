<template>
  <div class="verti bg-black-50 h-screen">
    <navbar />
    <div class="verti h-full flex container">
      <funds-view class="my-5" />
      <campaing-expose class="mb-auto" />
      <github-pages />
    </div>
    <footer-menu />
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import Navbar from '@/components/navbar/Navbar.vue'
import FooterMenu from '@/components/footer/FooterMenu.vue'
import CampaingExpose from '@/components/campaing/campaingExpose.vue'
import GithubPages from '@/components/githubPages/githubPages.vue'
import FundsView from '@/components/funds/fundsView.vue'
@Component({
  components: {
    FundsView,
    GithubPages,
    CampaingExpose,
    Navbar,
    FooterMenu,
  },
})
export default class HomeView extends Vue {}
</script>

<style lang="scss" scoped></style>
