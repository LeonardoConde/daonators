<template>
  <div class="bg-black-50 h-screen">
    <navbar />
    <div class="h-screen container">
      <campaing-expose />
    </div>
    <footer-menu />
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import Navbar from '@/components/navbar/Navbar.vue'
import FooterMenu from '@/components/footer/FooterMenu.vue'
import CampaingExpose from '@/components/campaing/campaingExpose.vue'
import {AuthAdmCollection} from '@/model/collection/AuthAdmCollection'
import {GetCampaignsResponse} from '@/model/response/GetCampaignsResponse'

@Component({
  components: {
    CampaingExpose,
    Navbar,
    FooterMenu,
  },
})
export default class HomeView extends Vue {}
</script>

<style lang="scss" scoped></style>
