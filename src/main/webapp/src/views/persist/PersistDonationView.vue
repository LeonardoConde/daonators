<template>
  <div class="view">
    <header class="header">
      <h1 class="header__title">
        {{ $t('resource.Donation') }}
      </h1>
    </header>

    <section class="relative">
      <await name="getDonation" class="px-4 py-8">
        <form class="container card w-full lg:w-160" @submit.prevent="persist">
          <div class="mb-8 grid md:grid-cols-2 gap-4">
            <render-schema
              v-for="field in schema.allFields"
              v-model="donation"
              :schema="schema"
              :field="field"
              :key="field"
            />
          </div>

          <await name="persistDonation" class="items-center-center">
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
import {Donation} from '@/model/resource/Donation'
import {InputDonationSchema} from '@/schema/resource/Donation/InputDonationSchema'

@Component
export default class PersistDonationView extends Vue {
  @Prop() id1?: string
  @Prop() id2?: string
  @Prop() id3?: string

  @Provide('validator') validator = this.$validator

  schema = new InputDonationSchema()
  donation = new Donation()

  async created() {
    this.populateResource()
    await this.populate()
  }

  populateResource() {
    this.schema.collectionCampaing.queryAsPage()
    this.schema.collectionOrganization.queryAsPage()
  }

  async populate() {
    const id1 = Number(this.id1) || null
    const id2 = Number(this.id2) || null
    const id3 = Number(this.id3) || null

    if (id1 && id2 && id3) {
      await this.donation.getDonation(id1, id2, id3)
    }

    this.$await.done('getDonation')
  }

  async persist() {
    const isValid = await this.validator.validateAll()

    if (!isValid) {
      this.$toast.abort('system.error.validation')
    }

    await this.donation.persistDonation()
    this.$toast.success('system.success.persist')
    await this.$nav.push('/donation/list')
  }
}
</script>
