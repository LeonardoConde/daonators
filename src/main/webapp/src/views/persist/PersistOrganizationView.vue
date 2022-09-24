<template>
  <div class="view">
    <header class="header">
      <h1 class="header__title">
        {{ $t('resource.Organization') }}
      </h1>
    </header>

    <section class="relative">
      <await name="getOrganization" class="px-4 py-8">
        <form class="container card w-full lg:w-160" @submit.prevent="persist">
          <div class="mb-8 grid md:grid-cols-2 gap-4">
            <render-schema
              v-for="field in schema.allFields"
              v-model="organization"
              :schema="schema"
              :field="field"
              :key="field"
            />
          </div>

          <await name="persistOrganization" class="items-center-center">
            <button
              type="submit"
              class="h-12 px-20 btn btn--contrast bg-secondary"
            >
              {{ $t('app.submit') }}
            </button>
          </await>
        </form>
      </await>
    </section>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Watch, Provide, Vue} from 'vue-property-decorator'
import {Organization} from '@/model/resource/Organization'
import {InputOrganizationSchema} from '@/schema/resource/Organization/InputOrganizationSchema'

@Component
export default class PersistOrganizationView extends Vue {
  @Prop() id?: string

  @Provide('validator') validator = this.$validator

  schema = new InputOrganizationSchema()
  organization = new Organization()

  async created() {
    this.populateResource()
    await this.populate()
  }

  populateResource() {
    this.schema.collectionOrganizationType.queryAsPage()
  }

  async populate() {
    const id = Number(this.id) || null

    if (id) {
      await this.organization.getOrganization(id)
    }

    this.$await.done('getOrganization')
  }

  async persist() {
    const isValid = await this.validator.validateAll()

    if (!isValid) {
      this.$toast.abort('system.error.validation')
    }

    await this.organization.persistOrganization()
    this.$toast.success('system.success.persist')
    await this.$nav.push('/organization/list')
  }
}
</script>
