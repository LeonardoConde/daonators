<template>
  <div class=" hover:border-0">
    <button class="votingCard" @click="toggleVote()">
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
          class=" votingCard__status w-32 lg:w-48"
          :class="
            isVoteOpen()
              ? 'votingCard__status--aberto'
              : 'votingCard__status--fechado'
          "
        >
          <div v-if="isVoteOpen()">
            {{ $t('votingcard.aberto') }}
          </div>
          <div v-else>
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
    <modal v-model="openModal" :closable="false" :closeOutside="false">
      <voting-modal :item="item" @submit="toggleVote()" />
    </modal>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {Campaing} from '@/model/resource/Campaing'
import {Modal} from '@simpli/vue-modal'
import VotingModal from '@/components/voting/VotingModal.vue'

@Component({components: {VotingModal, Modal}})
export default class VotingCard extends Vue {
  @Prop({type: Object, required: true}) item!: Campaing
  openModal: boolean = false

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

  private toggleVote(): void {
    this.openModal = !this.openModal
  }

  forceClose() {
    if (this.openModal == true) {
      this.openModal = false
    }
  }
}
</script>

<style lang="scss" scoped>
.votingCard {
  @apply rounded-2xl border-2 border-black w-full text-lg py-4 shadow-xl;
  &__nome {
    @apply text-xl mb-4 text-white font-bold py-1;
  }
  &__status {
    @apply rounded-2xl p-2 justify-center horiz;
    &--aberto {
      @apply bg-green-400;
    }
    &--fechado {
      @apply bg-red-500;
    }
  }
}
</style>
