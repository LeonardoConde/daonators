<template>
  <button class="votingCard">
    <!-- nome -->
    <div
      class="votingCard__nome"
      :class="item.active ? ' bg-primary' : 'bg-red-600'"
    >
      {{ item.name }}
    </div>
    <div class="px-4">
      <div class="font-bold self-start">Hash:</div>
      <div>{{ item.scriptHash }}</div>
      <!-- tipo -->
    </div>
  </button>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {Voting} from '@/model/resource/Voting'
import {Organization} from '@/model/resource/Organization'

@Component
export default class OrgCard extends Vue {
  @Prop({type: Object, required: true}) item!: Organization
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
