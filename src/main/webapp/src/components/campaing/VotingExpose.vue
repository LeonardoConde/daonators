<template>
  <div class="verti my-6">
    <span class="text-4xl mx-auto">
      {{ $t('campaingExpose.view.openVotings') }}
    </span>

    <div class="my-6" />

    <div class="grid grid-cols-2 gap-8">
      <voting-expose-card v-for="(item, i) in votings" :item="item" :key="i" />
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import {DaoContract} from '@/model/contracts/DaoContract'
import {GetVotingsResponse} from '@/model/response/GetVotingsResponse'
import VotingExposeCard from '@/components/campaing/VotingExposeCard.vue'

@Component({components: {VotingExposeCard}})
export default class VotingExpose extends Vue {
  contract = new DaoContract()
  votings: GetVotingsResponse[] | null = null

  async created() {
    this.votings = await this.contract.getVotings()
  }
}
</script>

<style lang="scss" scoped></style>
