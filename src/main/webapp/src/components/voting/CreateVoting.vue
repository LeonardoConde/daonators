<template>
  <div class="p-4">
    <div class="font-bold text-xl">Tipo da votação:</div>
    <input-text v-model="voteType" />

    <div class="items-center-center mt-3">
      <button
        class="mt-3 text-lg text-white rounded-xl px-6 py-1"
        :class="voteType == null ? 'bg-gray-600' : 'bg-primary'"
        :disabled="voteType == null"
        @click="createVoting"
      >
        Criar
      </button>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import {InputText, InputSelect} from '@simpli/vue-input'
import {DaoContract} from '@/model/contracts/DaoContract'
import {GetOrganizationResponse} from '@/model/response/GetOrganizationResponse'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'

@Component({components: {InputSelect, InputText}})
export default class CreateVoting extends Vue {
  contract = new DaoContract()
  orgs: GetOrganizationResponse[] = []
  voteType: string | null = null
  async created() {
    this.orgs = (await this.contract.getOrgs()) || []
  }
  votingTypes = [
    {
      $id: 1,
      $tag: 'Saúde',
    },
    {
      $id: 2,
      $tag: 'Natureza',
    },
    {
      $id: 3,
      $tag: 'Educação',
    },
    {
      $id: 4,
      $tag: 'Animais marinhos',
    },
    {
      $id: 5,
      $tag: 'Limpeza dos oceanos',
    },
  ]

  createVoting() {
    this.contract.createVoting(this.voteType as string)
    this.$emit('close')
  }
}
</script>

<style scoped></style>
