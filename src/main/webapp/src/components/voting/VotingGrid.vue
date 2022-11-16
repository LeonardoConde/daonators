<template>
  <await
    name="listExportCampaing"
    :spinnerScale="0.8"
    class="verti items-center"
  >
    <h1>{{ $t('resource.Voting') }}</h1>
    <voting-public-filter :collection="collection" />

    <div class="grid grid-cols-3 gap-8 container mt-4 ">
      <voting-card
        v-for="(card, i) in collection.items"
        :key="i"
        :item="card"
      />
    </div>
    <div class="mt-4 place-self-center">
      <adap-pagination :collection="collection" class=" text-md " />
    </div>
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
@Component({
  components: {VotingPublicFilter, VotingCard, FilterToggle, FilterCampaing},
})
export default class VotingGrid extends Vue {
  collection = new VotingCollection()
  filterOpen = false

  async created() {
    this.collection.perPage = 12
    await this.collection?.queryAsPage()
  }
}
</script>

<style lang="scss" scoped></style>
