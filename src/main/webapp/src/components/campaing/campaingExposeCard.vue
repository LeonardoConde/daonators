<template>
  <div class="text-lg border border-black rounded-3xl px-auto py-3">
    <div class="horiz w-full mt-3">
      <div class="w-1/2 items-center-center">
        {{ $t('campaingExpose.card.voteName') }}
      </div>
      <div class="w-1/2 items-center-center">{{ item.nome }}</div>
    </div>
    <div class="horiz my-3">
      <div class="w-1/2 items-center-center">
        {{ $t('campaingExpose.card.voteHash') }}
      </div>
      <div class="w-1/2 items-center-center">{{ item.hash }}</div>
    </div>
    <div class="horiz  items-center-center my-3">
      <button
        v-if="!hasVotedOnThis"
        @click="vote"
        class="bg-green-400 py-1 px-3 rounded-lg"
      >
        {{ $t('campaingExpose.card.vote') }}
      </button>
      <button v-else @click="unvote" class="bg-red-500 py-1 px-3 rounded-lg">
        {{ $t('campaingExpose.card.unvote') }}
      </button>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {GetCampaignsResponse} from '@/model/response/GetCampaignsResponse'
import {DaoContract} from '@/model/contracts/DaoContract'

@Component
export default class campaingExposeCard extends Vue {
  @Prop({type: Object, required: true}) item!: GetCampaignsResponse
  @Prop({type: Boolean, required: true}) hasVotedOnThis!: boolean

  contract = new DaoContract()

  async vote() {
    const hash = await this.contract.vote(this.item.hash)
    this.$emit('hash', hash)
    this.$toast.info('campaingExpose.card.blockchainProcess')
  }

  async unvote() {
    const hash = await this.contract.removeVote(this.item.hash)
    this.$emit('hash', hash)
    this.$toast.info('campaingExpose.card.blockchainProcess')
  }
}
</script>

<style lang="scss" scoped></style>
