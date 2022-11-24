<template>
  <button class="votingCard">
    <!-- nome -->
    <div class="votingCard__nome bg-primary">
      {{ item.getName() }}
    </div>
    <div class="grid grid-cols-2 gap-4 px-4">
      <!-- tipo -->
      <div class="horiz weight-1 my-auto">
        <div class="font-bold">
          {{ $t('votingcard.tipo') }}
        </div>
        <div class="ml-1">
          {{ item.getTipo() }}
        </div>
      </div>
      <!-- estado -->
      <div />
      <!-- comeco -->
      <div class="horiz weight-1">
        <div class="font-bold">{{ $t('votingcard.inicio') }}</div>
        <div class="ml-1">{{ item.formattedBegging }}</div>
      </div>
      <!-- fim -->
      <div class="horiz weight-1">
        <div class="font-bold">{{ $t('votingcard.fim') }}</div>
        <div class="ml-1">{{ item.formattedEnd }}</div>
      </div>
    </div>
  </button>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {Voting} from '@/model/resource/Voting'

@Component
export default class VotingCard extends Vue {
  @Prop({type: Object, required: true}) item!: Voting
  isVoteOpen() {
    if (!this.item.campaing?.endDate) return true
    const dateEnd = new Date(this.item.campaing?.endDate)
    const now = new Date()
    return dateEnd > now
  }
  hasNoEnd() {
    return this.item.campaing?.endDate
      ? this.item.campaing?.formattedEnd
      : this.$t('votingcard.semfim')
  }
}
</script>

<style lang="scss" scoped>
.votingCard {
  @apply rounded-2xl border-2 border-black text-xl py-4 shadow-xl;
  &__nome {
    @apply text-3xl mb-4 text-white font-bold py-1;
  }
  &__status {
    @apply rounded-2xl p-2 justify-center horiz weight-1;
    &--aberto {
      @apply bg-green-400;
    }
    &--fechado {
      @apply bg-red-600;
    }
  }
}
</style>
