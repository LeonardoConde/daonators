<template>
  <div class="view">
    <header class="header">
      <h1 class="header__title">
        {{ $t('resource.AuthAdm') }}
      </h1>
    </header>

    <section class="relative">
      <await name="getAuthAdm" class="px-4 py-8">
        <form class="container card w-full lg:w-160" @submit.prevent="persist">
          <div class="mb-8 grid md:grid-cols-2 gap-4">
            <render-schema
              v-for="field in schema.allFields"
              v-model="authAdm"
              :schema="schema"
              :field="field"
              :key="field"
            />
          </div>

          <await name="persistAuthAdm" class="items-center-center">
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
import {AuthAdm} from '@/model/resource/AuthAdm'
import {InputAuthAdmSchema} from '@/schema/resource/AuthAdm/InputAuthAdmSchema'

@Component
export default class PersistAuthAdmView extends Vue {
  @Prop() id?: string

  @Provide('validator') validator = this.$validator

  schema = new InputAuthAdmSchema()
  authAdm = new AuthAdm()

  async created() {
    await this.populate()
  }

  async populate() {
    const id = Number(this.id) || null

    if (id) {
      await this.authAdm.getAuthAdm(id)
    }

    this.$await.done('getAuthAdm')
  }

  async persist() {
    const isValid = await this.validator.validateAll()

    if (!isValid) {
      this.$toast.abort('system.error.validation')
    }

    await this.authAdm.persistAuthAdm()
    this.$toast.success('system.success.persist')
    await this.$nav.push('/auth-adm/list')
  }
}
</script>
