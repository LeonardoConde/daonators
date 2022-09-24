<template>
  <div class="filter-campaing-organization">
    <div class="filter-campaing-organization__content">
      <div v-for="field in schema.allFields" :key="field">
        <render-schema v-model="collection" :schema="schema" :field="field" />
      </div>
    </div>

    <await name="softQuery" spinner="MoonLoader" class="self-center">
      <button @click="doFilter" class="lg:w-40 btn btn--contrast bg-secondary">
        {{ $t('app.filter') }}
      </button>
    </await>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Watch, Vue} from 'vue-property-decorator'
import {CampaingOrganizationCollection} from '@/model/collection/CampaingOrganizationCollection'
import {FilterCampaingOrganizationSchema} from '@/schema/resource/CampaingOrganization/FilterCampaingOrganizationSchema'

@Component
export default class FilterCampaingOrganization extends Vue {
  @Prop({type: Object, required: true})
  collection!: CampaingOrganizationCollection

  schema = new FilterCampaingOrganizationSchema()

  async created() {
    await this.populateFilterOptions()
  }

  async populateFilterOptions() {
    this.collection.resource = this.schema

    const promises: Array<Promise<any>> = [
      this.collection.resource.collectionCampaing.queryAsPage(),
      this.collection.resource.collectionOrganization.queryAsPage(),
    ]

    await this.$await.run('softQuery', () => Promise.all(promises))
  }

  async doFilter() {
    this.$emit('submit')
    await this.$await.run('softQuery', () => this.collection.queryAsPage())
  }
}
</script>

<style lang="scss" scoped>
.filter-campaing-organization {
  @apply verti p-4 border-b border-primary;

  .filter-campaing-organization__content {
    @apply mb-8 grid gap-4;

    @screen sm {
      @apply grid-cols-2;
    }

    @screen md {
      @apply grid-cols-3;
    }

    @screen lg {
      @apply grid-cols-4;
    }
  }
}
</style>
