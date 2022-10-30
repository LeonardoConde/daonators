<template>
  <button class="votingCard">
    <!-- nome -->
    <div class="votingCard__nome bg-primary">
      {{ item.name }}
    </div>
    <div class="grid grid-cols-2 gap-4 px-4">
      <!-- tipo -->
      <div class="horiz weight-1 my-auto">
        <div class="font-bold">{{ $t('votingcard.tipo') }}</div>
        <div class="ml-1">{{ item.campaingType.name }}</div>
      </div>
      <!-- estado -->
      <div
        class=" votingCard__status "
        :class="
          isVoteOpen()
            ? 'votingCard__status--aberto'
            : 'votingCard__status--fechado'
        "
      >
        <div v-if="isVoteOpen()" class="">
          {{ $t('votingcard.aberto') }}
        </div>
        <div v-else class="">
          {{ $t('votingcard.fechado') }}
        </div>
      </div>
      <!-- comeco -->
      <div class="horiz weight-1">
        <div class="font-bold">{{ $t('votingcard.inicio') }}</div>
        <div class="ml-1">{{ item.formattedBegging }}</div>
      </div>
      <!-- fim -->
      <div class="horiz weight-1">
        <div class="font-bold">{{ $t('votingcard.fim') }}</div>
        <div class="ml-1">{{ hasNoEnd() }}</div>
      </div>
    </div>
  </button>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {Campaing} from '@/model/resource/Campaing'

@Component
export default class VotingCard extends Vue {
  @Prop({type: Object, required: true}) item!: Campaing
  isVoteOpen() {
    if (!this.item.endDate) return true
    const dateEnd = new Date(this.item.endDate)
    const now = new Date()
    return dateEnd > now
  }
  hasNoEnd() {
    return this.item.endDate
      ? this.item.formattedEnd
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
