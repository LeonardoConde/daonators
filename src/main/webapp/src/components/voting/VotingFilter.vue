<template>
  <div class="md:horiz rounded-3xl bg-primary items-center shadow-2xl mt-5 p-5">
    <adap-searchfield
      :collection="collection"
      :placeholder="$t('app.search')"
      class="input h-8"
    />

    <div class="items-center" v-for="field in schema.allFields" :key="field">
      <render-schema
        class="ml-3 text-white"
        v-model="collection"
        :schema="schema"
        :field="field"
      />
    </div>
    <await name="softQuery" spinner="MoonLoader" class="self-center">
      <button
        @click="doFilter"
        class="lg:w-40 ml-3 btn btn--contrast bg-secondary"
      >
        {{ $t('app.filter') }}
      </button>
    </await>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {CampaingCollection} from '@/model/collection/CampaingCollection'
import {FilterCampaingSchema} from '@/schema/resource/Campaing/FilterCampaingSchema'

@Component
export default class VotingFilter extends Vue {
  @Prop({type: Object, required: true}) collection!: CampaingCollection

  schema = new FilterCampaingSchema()

  async created() {
    await this.populateFilterOptions()
  }

  async populateFilterOptions() {
    this.collection.resource = this.schema

    const promises: Array<Promise<any>> = [
      this.collection.resource.collectionCampaingType.queryAsPage(),
    ]

    await this.$await.run('softQuery', () => Promise.all(promises))
  }

  maconha() {
    console.log('aaa')
  }

  async doFilter() {
    this.$emit('submit')
    this.collection.currentPage = 0
    await this.$await.run('softQuery', () => this.collection.queryAsPage())
  }
}
</script>

<style scoped></style>
