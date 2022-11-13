<template>
  <div class="view">
    <header class="header">
      <h1 class="header__title">
        {{ $t('resource.VotingType') }}
      </h1>
    </header>

    <section class="relative">
      <await name="getVotingType" class="px-4 py-8">
        <form class="container card w-full lg:w-160" @submit.prevent="persist">
          <div class="mb-8 grid md:grid-cols-2 gap-4">
            <render-schema
              v-for="field in schema.allFields"
              v-model="votingType"
              :schema="schema"
              :field="field"
              :key="field"
            />
          </div>

          <await name="persistVotingType" class="items-center-center">
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
import {VotingType} from '@/model/resource/VotingType'
import {InputVotingTypeSchema} from '@/schema/resource/VotingType/InputVotingTypeSchema'

@Component
export default class PersistVotingTypeView extends Vue {
  @Prop() id?: string

  @Provide('validator') validator = this.$validator

  schema = new InputVotingTypeSchema()
  votingType = new VotingType()

  async created() {
    await this.populate()
  }

  async populate() {
    const id = Number(this.id) || null

    if (id) {
      await this.votingType.getVotingType(id)
    }

    this.$await.done('getVotingType')
  }

  async persist() {
    const isValid = await this.validator.validateAll()

    if (!isValid) {
      this.$toast.abort('system.error.validation')
    }

    await this.votingType.persistVotingType()
    this.$toast.success('system.success.persist')
    await this.$nav.push('/voting-type/list')
  }
}
</script>
