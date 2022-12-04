<template>
  <await
    name="listExportCampaing"
    :spinnerScale="0.8"
    class="verti items-center"
  >
    <h1>{{ $t('resource.Voting') }}</h1>
    <div class="horiz">
      <button
        class="text-xl font-bold text-white bg-primary rounded-2xl py-2 px-5"
        @click="openVotingCreation"
      >
        Criar votação
      </button>
      <button
        class="ml-3 text-xl font-bold text-white bg-primary rounded-2xl py-2 px-5"
      >
        Editar suas votações
      </button>
    </div>

    <div class="grid grid-cols-2 gap-8 container mt-4 ">
      <voting-card
        v-for="(card, i) in collection.items"
        :key="i"
        :item="card"
      />
    </div>
    <div class="mt-4 place-self-center">
      <adap-pagination :collection="collection" class=" text-md " />
    </div>
    <modal v-model="modalOpen" :closable="true" :closeOutside="false">
      <create-voting @close="openVotingCreation" />
    </modal>
  </await>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import VotingCard from '@/components/voting/VotingCard.vue'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import FilterToggle from '@/components/FilterToggle.vue'
import FilterCampaing from '@/components/filters/FilterCampaing.vue'
import {VotingCollection} from '@/model/collection/VotingCollection'
import VotingPublicFilter from '@/components/voting/VotingPublicFilter.vue'
import CreateVoting from '@/components/voting/CreateVoting.vue'
@Component({
  components: {
    CreateVoting,
    VotingPublicFilter,
    VotingCard,
    FilterToggle,
    FilterCampaing,
  },
})
export default class VotingGrid extends Vue {
  collection = new VotingCollection()
  modalOpen = false
  filterOpen = true

  async created() {
    this.collection.perPage = 12
    await this.collection?.queryAsPage()
  }

  openVotingCreation() {
    this.modalOpen = !this.modalOpen
  }
}
</script>

<style lang="scss" scoped></style>
