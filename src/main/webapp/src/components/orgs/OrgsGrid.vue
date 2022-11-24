<template>
  <await
    name="listExportCampaing"
    :spinnerScale="0.8"
    class="verti items-center"
  >
    <h1>{{ $t('resource.Organization') }}</h1>

    <div class="grid grid-cols-2 gap-8 container mt-4 ">
      <org-card v-for="(card, i) in collection.items" :key="i" :item="card" />
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
import {OrganizationCollection} from '@/model/collection/OrganizationCollection'
import OrgCard from '@/components/orgs/OrgCard.vue'
@Component({
  components: {OrgCard},
})
export default class OrgsGrid extends Vue {
  collection = new OrganizationCollection()
  filterOpen = false

  async created() {
    this.collection.perPage = 12
    await this.collection?.queryAsPage()
  }
}
</script>

<style lang="scss" scoped></style>
