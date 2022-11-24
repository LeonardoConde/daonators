<template>
  <div class="verti my-6">
    <span class="text-4xl mx-auto">
      {{ $t('campaingExpose.view.openVotings') }}
    </span>
    <div class="horiz text-lg mx-auto my-6">
      <span v-if="!!lastHash" class="font-bold">
        {{ $t('campaingExpose.view.lastHash') }}
      </span>
      <span class="ml-2">{{ lastHash }}</span>
    </div>

    <div class="grid grid-cols-2 gap-8">
      <campaing-expose-card
        v-for="(item, i) in campaigns"
        :item="item"
        :key="i"
        @hash="defineHash"
      />
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import {DaoContract} from '@/model/contracts/DaoContract'
import {GetCampaignsResponse} from '@/model/response/GetCampaignsResponse'
import CampaingExposeCard from '@/components/campaing/campaingExposeCard.vue'
@Component({
  components: {CampaingExposeCard},
})
export default class campaingExpose extends Vue {
  contract = new DaoContract()
  campaigns: GetCampaignsResponse[] | null = null
  lastHash: String | null = null

  defineHash(hash: string) {
    this.lastHash = hash
  }

  async created() {
    this.contract.getOrgs()
    this.campaigns = await this.contract.getCampaigns()
    this.campaigns.forEach((element: GetCampaignsResponse) => {
      //this.contract.getCampaign(element.hash)
    })
  }
}
</script>

<style lang="scss" scoped></style>
