<template>
  <div class="verti items-center-center ">
    <div class="text-4xl my-6">Valor arrecadado:</div>
    <div class="text-6xl horiz border border-black rounded-xl p-3">
      <span>{{ valor }}</span>
      <span class="mx-3">GAS</span>
      <img src="@/assets/img/gas.png" />
    </div>
    <a
      class="mt-5 text-lg text-primary"
      href="https://coinmarketcap.com/"
      target="_blank"
    >
      Achou pouco? Clique aqui e compre nossos tokens para aumentar o valor!
    </a>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import {DaoContract} from '@/model/contracts/DaoContract'

@Component
export default class fundsView extends Vue {
  contract = new DaoContract()
  valor = '0'

  async created() {
    this.valor = await this.contract.getAmountToDonate()
  }
}
</script>

<style lang="scss" scoped></style>
