<template>
  <div class="view">
    <header class="header">
      <h1 class="header__title">
        {{ $t('resource.OrganizationType') }}
      </h1>

      <div class="header__items">
        <adap-searchfield
          :collection="collection"
          :placeholder="$t('app.search')"
          class="input h-8"
        />

        <filter-toggle v-model="filterOpen" />

        <await name="listOrganizationType" :spinnerScale="0.8" class="w-12" />

        <div class="weight-1"></div>

        <span v-if="!collection.isEmpty()">
          {{ $t('app.totalLines', {total: collection.total}) }}
        </span>

        <await name="listExportOrganizationType" :spinnerScale="0.8">
          <button @click="downloadXlsx" class="btn btn--solid">
            {{ $t('app.downloadXlsx') }}
          </button>
        </await>

        <router-link
          to="/organization-type/new"
          class="btn btn--contrast bg-secondary"
        >
          {{ $t('app.add') }}
        </router-link>
      </div>

      <transition-expand>
        <div v-show="filterOpen" class="z-10">
          <filter-organization-type :collection="collection" />
        </div>
      </transition-expand>
    </header>

    <section>
      <await
        name="hardQuery"
        class="relative verti items-center"
        effect="fade-up"
        spinner="MoonLoader"
        spinnerPadding="20px"
      >
        <template v-if="collection.isEmpty()">
          <div
            class="mt-10 uppercase text-center text-black-600 text-lg font-light"
          >
            {{ $t('app.noDataToShow') }}
          </div>
        </template>

        <template v-else>
          <div class="w-full overflow-x-auto">
            <table class="table">
              <thead>
                <tr>
                  <th />

                  <th v-for="(value, key) in schema.header" :key="key">
                    <adap-orderby
                      :collection="collection"
                      :name="key"
                      :label="value"
                    />
                  </th>
                </tr>
              </thead>

              <tbody>
                <tr v-for="(item, i) in collection.items" :key="item.$id">
                  <td>
                    <div class="horiz children:mx-1">
                      <a
                        @click="goToPersistView(item)"
                        class="btn btn--flat btn--icon"
                      >
                        <i class="far fa-edit" />
                      </a>
                      <a
                        @click="removeItem(item)"
                        class="btn btn--flat btn--icon"
                      >
                        <i class="far fa-trash-alt" />
                      </a>
                    </div>
                  </td>

                  <td v-for="field in schema.allFields" :key="field">
                    <render-schema
                      v-model="collection.items[i]"
                      :schema="schema"
                      :field="field"
                    />
                  </td>
                </tr>
              </tbody>
            </table>
          </div>

          <div class="fixed z-10 bottom-4">
            <adap-pagination :collection="collection" class="m-auto" />
          </div>
        </template>

        <await name="softQuery" class="z-20 await__spinner--screen-light" />
      </await>
    </section>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Watch, Mixins} from 'vue-property-decorator'
import {MixinRouteMatch} from '@/components/mixins/MixinRouteMatch'
import FilterToggle from '@/components/FilterToggle.vue'
import FilterOrganizationType from '@/components/filters/FilterOrganizationType.vue'
import {OrganizationType} from '@/model/resource/OrganizationType'
import {OrganizationTypeCollection} from '@/model/collection/OrganizationTypeCollection'
import {ListOrganizationTypeSchema} from '@/schema/resource/OrganizationType/ListOrganizationTypeSchema'
import {ExportOrganizationTypeSchema} from '@/schema/resource/OrganizationType/ExportOrganizationTypeSchema'

@Component({
  components: {FilterToggle, FilterOrganizationType},
})
export default class ListOrganizationTypeView extends Mixins(MixinRouteMatch) {
  schema = new ListOrganizationTypeSchema()
  collection = new OrganizationTypeCollection()
  filterOpen = false

  async created() {
    if (this.hasQueryParams) {
      this.updateObjectFromRoute(this.collection)
    }
    await this.$await.run('hardQuery', () => this.collection.queryAsPage())
  }

  @Watch('collection', {deep: true})
  collectionEvent() {
    this.updateRouteFromObject(this.collection)
  }

  goToPersistView(item: OrganizationType) {
    this.$nav.pushByName('editOrganizationType', item.$id)
  }

  async removeItem(item: OrganizationType) {
    await this.$dialog.remove(item)
    await item.removeOrganizationType()
    await this.collection.queryAsPage()
  }

  async downloadXlsx() {
    const {ascending, orderBy, page, limit, ...params} = this.collection.params

    const coll = new OrganizationTypeCollection()
      .clearFilters()
      .addFilter(params)

    await coll.listExportOrganizationType()
    this.$xlsx.downloadFromSchema(
      coll.items,
      new ExportOrganizationTypeSchema()
    )
  }
}
</script>
