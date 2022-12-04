<template>
  <div class="">
    <button
      @click="openModal = !openModal"
      class="w-full border border-black rounded-xl p-3 text-lg grid grid-cols-2 items-center gap-3"
    >
      <span class="font-bold">Campanha sobre:</span>
      <span class="bg-blue-200 rounded-xl">{{ item.campaignType.name }}</span>
      <span class="font-bold">Organizações elegivéis:</span>
      <span class="bg-blue-200 rounded-xl">
        {{ item.campaignHashList.length }}
      </span>
    </button>
    <modal
      v-model="openModal"
      :closable="true"
      :closeOutside="false"
      innerClass="large"
    >
      <campaing-expose :hash-list="item.campaignHashList" />
    </modal>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {GetVotingsResponse} from '@/model/response/GetVotingsResponse'
import {Modal} from '@simpli/vue-modal'
import CampaingExpose from '@/components/campaing/campaingExpose.vue'
@Component({components: {CampaingExpose, Modal}})
export default class VotingExposeCard extends Vue {
  @Prop({type: Object, required: true}) item!: GetVotingsResponse
  openModal = false
}
</script>

<style scoped></style>
