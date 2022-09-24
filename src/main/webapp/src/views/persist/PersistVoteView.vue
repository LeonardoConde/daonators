<template>
  <div class="view">
    <header class="header">
      <h1 class="header__title">
        {{ $t('resource.Vote') }}
      </h1>
    </header>

    <section class="relative">
      <await name="getVote" class="px-4 py-8">
        <form class="container card w-full lg:w-160" @submit.prevent="persist">
          <div class="mb-8 grid md:grid-cols-2 gap-4">
            <render-schema
              v-for="field in schema.allFields"
              v-model="vote"
              :schema="schema"
              :field="field"
              :key="field"
            />
          </div>

          <await name="persistVote" class="items-center-center">
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
import {Vote} from '@/model/resource/Vote'
import {InputVoteSchema} from '@/schema/resource/Vote/InputVoteSchema'

@Component
export default class PersistVoteView extends Vue {
  @Prop() id?: string

  @Provide('validator') validator = this.$validator

  schema = new InputVoteSchema()
  vote = new Vote()

  async created() {
    this.populateResource()
    await this.populate()
  }

  populateResource() {
    this.schema.collectionCampaingOrganization.queryAsPage()
    this.schema.collectionUserWallet.queryAsPage()
  }

  async populate() {
    const id = Number(this.id) || null

    if (id) {
      await this.vote.getVote(id)
    }

    this.$await.done('getVote')
  }

  async persist() {
    const isValid = await this.validator.validateAll()

    if (!isValid) {
      this.$toast.abort('system.error.validation')
    }

    await this.vote.persistVote()
    this.$toast.success('system.success.persist')
    await this.$nav.push('/vote/list')
  }
}
</script>
