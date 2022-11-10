<template>
  <div class="verti">
    <voting-filter class="self-center" :collection="collection" />
    <await name="listCampaing" :spinnerScale="0.8" class="w-12" />
    <div
      v-if="!collection.isEmpty()"
      class="grid md:grid-cols-2 gap-8 container my-10"
    >
      <voting-card
        v-for="(card, i) in collection.items"
        :key="i"
        :item="card"
      />
    </div>
    <div class="place-self-center mb-10">
      <adap-pagination :collection="collection" class="text-md" />
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import VotingCard from '@/components/voting/VotingCard.vue'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import FilterToggle from '@/components/FilterToggle.vue'
import FilterCampaing from '@/components/filters/FilterCampaing.vue'
import VotingFilter from '@/components/voting/VotingFilter.vue'
@Component({
  components: {VotingFilter, VotingCard, FilterToggle, FilterCampaing},
})
export default class VotingGrid extends Vue {
  collection = new CampaingCollection()
  async created() {
    this.collection.perPage = 12
    await this.collection?.queryAsPage()
  }
}
</script>

<style lang="scss" scoped></style>
