<template>
  <div class="voting-public-filter">
    <adap-searchfield
      :collection="collection"
      :placeholder="$t('app.search')"
      class="input h-8 mx-2"
    />
    <await name="softQuery" spinner="MoonLoader" class="self-center">
      <button
        @click="doFilter"
        class="lg:w-40 btn btn--contrast bg-secondary mr-2"
      >
        {{ $t('app.filter') }}
      </button>
    </await>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {VotingCollection} from '@/model/collection/VotingCollection'
import {PublicFilterVotingSchema} from '@/schema/resource/Voting/PublicFilterVotingSchema'
@Component
export default class VotingPublicFilter extends Vue {
  @Prop({type: Object, required: true}) collection!: VotingCollection
  filterSchema = new PublicFilterVotingSchema()

  async doFilter() {
    this.$emit('submit')
    await this.$await.run('softQuery', () => this.collection.queryAsPage())
  }
}
</script>

<style lang="scss" scoped>
.voting-public-filter {
  @apply horiz px-5 py-2 rounded-2xl shadow-2xl my-5 border border-black;
  width: min-content;
}
</style>
