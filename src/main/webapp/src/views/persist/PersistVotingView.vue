<template>
  <div class="view">
    <header class="header">
      <h1 class="header__title">
        {{ $t('resource.Voting') }}
      </h1>
    </header>

    <section class="relative">
      <await name="getVoting" class="px-4 py-8">
        <form class="container card w-full lg:w-160" @submit.prevent="persist">
          <div class="mb-8 grid md:grid-cols-2 gap-4">
            <render-schema
              v-for="field in schema.allFields"
              v-model="voting"
              :schema="schema"
              :field="field"
              :key="field"
            />
          </div>

          <await name="persistVoting" class="items-center-center">
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
import {Voting} from '@/model/resource/Voting'
import {InputVotingSchema} from '@/schema/resource/Voting/InputVotingSchema'

@Component
export default class PersistVotingView extends Vue {
  @Prop() id1?: string
  @Prop() id2?: string

  @Provide('validator') validator = this.$validator

  schema = new InputVotingSchema()
  voting = new Voting()

  async created() {
    this.populateResource()
    await this.populate()
  }

  populateResource() {
    this.schema.collectionCampaing.queryAsPage()
    this.schema.collectionOrganization.queryAsPage()
    this.schema.collectionVotingType.queryAsPage()
  }

  async populate() {
    const id1 = Number(this.id1) || null
    const id2 = Number(this.id2) || null

    if (id1 && id2) {
      await this.voting.getVoting(id1, id2)
    }

    this.$await.done('getVoting')
  }

  async persist() {
    const isValid = await this.validator.validateAll()

    if (!isValid) {
      this.$toast.abort('system.error.validation')
    }

    await this.voting.persistVoting()
    this.$toast.success('system.success.persist')
    await this.$nav.push('/voting/list')
  }
}
</script>
