<template>
  <div class="verti">
    <div class="horiz ml-auto">
      <button @click="closeModal()">
        <i class="fas fa-times text-lg" />
      </button>
    </div>
    <div></div>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {Campaing} from '@/model/resource/Campaing'
import {Modal} from '@simpli/vue-modal'
import {CampaingOrganizationCollection} from '@/model/collection/CampaingOrganizationCollection'

@Component
export default class VotingModal extends Vue {
  @Prop({type: Object, required: true}) item!: Campaing
  collection = new CampaingOrganizationCollection()

  async created() {
    //this.collection.
  }

  closeModal() {
    this.$emit('submit')
  }
}
</script>

<style scoped></style>
