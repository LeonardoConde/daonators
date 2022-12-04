<template>
  <div class="verti my-6 px-4">
    <span class="text-4xl mx-auto">
      Organizações elegivéis:
    </span>
    <div v-if="!!lastHash" class="verti text-lg mx-auto my-6">
      <span class="font-bold">
        {{ $t('campaingExpose.view.lastHash') }}
      </span>
      <a
        :href="getDoraLink(lastHash)"
        class="w-full break-all "
        target="_blank"
      >
        {{ lastHash }}
      </a>
    </div>
    <div v-else class="my-6" />

    <div class=" md:px-32">
      <campaing-expose-card
        class="mb-5"
        v-for="(item, i) in hashList"
        :key="i"
        :has-voted-on-this="item == votedHash"
        @hash="defineHash"
        :hashR="item"
      />
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {DaoContract} from '@/model/contracts/DaoContract'
import {GetCampaignsResponse} from '@/model/response/GetCampaignsResponse'
import CampaingExposeCard from '@/components/campaing/campaingExposeCard.vue'
@Component({
  components: {CampaingExposeCard},
})
export default class campaingExpose extends Vue {
  @Prop({type: [], required: false}) hashList!: string[]
  contract = new DaoContract()
  campaigns: GetCampaignsResponse[] | null = null
  lastHash: String | null = null
  votedHash = ''

  async defineHash(hash: string) {
    this.lastHash = hash
    this.votedHash = await this.contract.getVotedCampaings()
  }

  getDoraLink(hash: string): string {
    return 'https://dora.coz.io/transaction/neo3/testnet/' + hash
  }

  async created() {
    //await this.contract.createCampaing()
    this.campaigns = await this.contract.getCampaigns()
    this.votedHash = await this.contract.getVotedCampaings()
  }
}
</script>

<style lang="scss" scoped></style>
