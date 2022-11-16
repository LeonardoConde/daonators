<template>
  <div class="verti ">
    <div class="horiz text-lg mx-auto my-6">
      <span class="font-bold"> {{ $t('campaingExpose.view.lastHash') }}</span>
      <span class="ml-2">{{ lastHash }}</span>
    </div>

    <div class="grid grid-cols-2 gap-8">
      <campaing-expose-card
        v-for="(item, i) in campaigns"
        :item="item"
        :key="i"
        @hash="defineHash"
      />
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import {rpc, sc, wallet} from '@cityofzion/neon-core'
import Neon from '@cityofzion/neon-js'
import {CommonConfig} from '@cityofzion/neon-js/lib/experimental/types'
import {NeonParser} from '@cityofzion/neon-parser'
import {NeonInvoker} from '@cityofzion/neon-invoker'
import {DaoContract} from '@/model/contracts/DaoContract'
import {GetCampaignsResponse} from '@/model/response/GetCampaignsResponse'
import CampaingExposeCard from '@/components/campaing/campaingExposeCard.vue'
@Component({
  components: {CampaingExposeCard},
})
export default class campaingExpose extends Vue {
  contract = new DaoContract()
  campaigns: GetCampaignsResponse[] | null = null
  lastHash: String | null = null
  // NODE = 'https://testnet1.neo.coz.io:443'
  // PRIVATE_KEY = 'Ky5hxa62UZ2PxfwDKviKjBcCnBFuyS9JUwSsTv6qLET21Ng9yeY1'
  // SIGNER = new wallet.Account(this.PRIVATE_KEY)
  // rpcNode = new rpc.RPCClient(this.NODE)
  // a: any
  // getVersionRes = async () => await this.rpcNode.getVersion()
  //
  // config: CommonConfig = {
  //   networkMagic: 894710606,
  //   rpcAddress: this.NODE,
  //   account: this.SIGNER,
  // }
  //
  // contract = new Neon.experimental.SmartContract(
  //   Neon.u.HexString.fromHex('0x0869620671c344e7e12ab50e707c6e3ac9fa4118'),
  //   this.config
  // )
  //
  // async iniciaCampanha() {
  //   const i = await NeonInvoker.init(this.NODE, this.SIGNER)
  //   const res = await i.invokeFunction({
  //     signers: [],
  //     invocations: [
  //       {
  //         scriptHash: '0x0869620671c344e7e12ab50e707c6e3ac9fa4118',
  //         operation: 'create_campaign',
  //         args: [
  //           {
  //             type: 'Hash160',
  //             value: NeonParser.reverseHex(
  //               NeonParser.strToHexstring('testeScriptHashNovo2')
  //             ),
  //           },
  //         ],
  //       },
  //     ],
  //   })
  //   console.log(res)
  // }

  defineHash(hash: string) {
    this.lastHash = hash
  }

  async testeza() {
    const a = await this.contract.vote(
      this.campaigns != null ? this.campaigns[0]?.hash : ''
    )
  }

  async created() {
    this.campaigns = await this.contract.getCampaigns()
    this.campaigns.forEach((element: GetCampaignsResponse) => {
      this.contract.getCampaign(element.hash)
    })

    // const tx = await this.rpcNode.getApplicationLog(
    //   '0x3f636af3679bd8abeb2fea7b697a20e22f689013722bedf9b0e45aa1f4e38653'
    // )
    //
    // console.log(
    //   'GAS consumed: ',
    //   parseInt((await tx).executions[0].gasconsumed) / 10 ** 8
    // )
    // tx.executions[0].notifications.map(n => {
    //   const notification = NeonParser.parseRpcResponse(n.state)
    //   const res = {
    //     eventName: n.eventname,
    //     value: notification,
    //   }
    //   console.log(`event: ${n.eventname}`)
    //   console.log(`  payload: ${JSON.stringify(notification)}`)
    // })
    // console.log('tx ->', tx)
    //
    // const res = await this.contract.testInvoke('get_campaigns')
    //
    // // voce pode fazer essa verificação aqui, mas acho que nao precisa
    // if (res.stack.length === 0) {
    //   throw new Error(res.exception ?? 'unrecognized response')
    // }
    //
    // const valorLegivel = NeonParser.parseRpcResponse(res.stack[0])
    // console.log('valorIL->', res)
    // console.log('valorL->', valorLegivel)
    // valorLegivel.forEach((element: any) => {
    //   console.log(NeonParser.base64ToUtf8(NeonParser.strToBase64(element[1])))
    // })
  }
}
</script>

<style lang="scss" scoped></style>
