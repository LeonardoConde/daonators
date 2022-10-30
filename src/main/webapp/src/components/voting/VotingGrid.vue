<template>
  <await name="listExportCampaing" :spinnerScale="0.8" class="verti">
    <header class="header">
      <h1 class="header__title ">
        {{ $t('resource.Campaing') }}
      </h1>

      <div class="header__items">
        <adap-searchfield
          :collection="collection"
          :placeholder="$t('app.search')"
          class="input h-8"
        />

        <filter-toggle v-model="filterOpen" />

        <await name="listCampaing" :spinnerScale="0.8" class="w-12" />

        <div class="weight-1"></div>

        <span v-if="!collection.isEmpty()">
          {{ $t('app.totalLines', {total: collection.total}) }}
        </span>
      </div>

      <transition-expand>
        <div v-show="filterOpen" class="z-10">
          <filter-campaing :collection="collection" />
        </div>
      </transition-expand>
    </header>

    <div class="grid grid-cols-2 gap-8 container mt-4 ">
      <voting-card
        v-for="(card, i) in collection.items"
        :key="i"
        :item="card"
      />
    </div>
    <div class="mt-4 place-self-center">
      <adap-pagination :collection="collection" class=" text-xl " />
    </div>
  </await>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import VotingCard from '@/components/voting/VotingCard.vue'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import FilterToggle from '@/components/FilterToggle.vue'
import FilterCampaing from '@/components/filters/FilterCampaing.vue'
@Component({
  components: {VotingCard, FilterToggle, FilterCampaing},
})
export default class VotingGrid extends Vue {
  collection = new CampaingCollection()
  filterOpen = false
  async created() {
    this.collection.perPage = 12
    await this.collection?.queryAsPage()
  }
}
</script>

<style lang="scss" scoped></style>
