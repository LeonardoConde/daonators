<template>
  <div class="text-lg border border-black rounded-3xl px-auto py-3">
    <div class="horiz w-full mt-3">
      <div class="w-1/2 items-center-center font-bold">
        {{ $t('campaingExpose.card.voteName') }}
      </div>
      <div class="w-1/2 items-center-center bg-blue-200 rounded-xl">
        {{ nome || '' }}
      </div>
    </div>
    <div class="horiz my-3">
      <div class="w-1/2 items-center-center font-bold">
        {{ $t('campaingExpose.card.voteHash') }}
      </div>
      <div class="w-1/2 items-center-center bg-blue-200 px-2 rounded-xl">
        {{ hashF || '' }}
      </div>
    </div>
    <div class="horiz items-center-center my-3" v-if="!!teste">
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
  @Prop({type: Boolean, required: true}) hasVotedOnThis!: boolean
  @Prop({type: String, required: true}) hashR!: string
  teste: GetCampaignsResponse | null = null

  contract = new DaoContract()

  async created() {
    this.teste = await this.contract.getCampaign(this.hashR)
  }

  async vote() {
    try {
      const hash = await this.contract.vote(this.hashR)
      this.$emit('hash', hash)
      this.$toast.info('campaingExpose.card.blockchainProcess')
    } catch (e) {
      this.$toast.error('campaingExpose.card.blockchainError')
    }
  }

  async unvote() {
    try {
      const hash = await this.contract.removeVote(this.hashR)
      this.$emit('hash', hash)
      this.$toast.info('campaingExpose.card.blockchainProcess')
    } catch (e) {
      this.$toast.error('campaingExpose.card.blockchainError')
    }
  }

  get nome() {
    return this.teste?.nome || ''
  }

  get hashF() {
    return this.teste?.hash || ''
  }
}
</script>

<style lang="scss" scoped></style>
