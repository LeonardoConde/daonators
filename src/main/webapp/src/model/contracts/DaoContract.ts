import {rpc, wallet} from '@cityofzion/neon-core'
import {CommonConfig} from '@cityofzion/neon-js/lib/experimental/types'
import Neon from '@cityofzion/neon-js'
import {NeonParser} from '@cityofzion/neon-parser'
import {GetCampaignsResponse} from '@/model/response/GetCampaignsResponse'
import {NeonInvoker} from '@cityofzion/neon-invoker'
import {GetOrganizationResponse} from '@/model/response/GetOrganizationResponse'
import {GetVotingsResponse} from '@/model/response/GetVotingsResponse'

export class DaoContract {
  NODE = 'https://testnet1.neo.coz.io:443'
  PRIVATE_KEY = 'Ky5hxa62UZ2PxfwDKviKjBcCnBFuyS9JUwSsTv6qLET21Ng9yeY1'
  SCRIPT_HASH = '0xa80f9f37bcac7979ebddee1cdc756386ac0d1d2a'
  SIGNER = new wallet.Account(this.PRIVATE_KEY)
  rpcNode = new rpc.RPCClient(this.NODE)
  config: CommonConfig = {
    networkMagic: 894710606,
    rpcAddress: this.NODE,
    account: this.SIGNER,
  }
  contract = new Neon.experimental.SmartContract(
    Neon.u.HexString.fromHex(this.SCRIPT_HASH),
    this.config
  )

  async getCampaigns(): Promise<GetCampaignsResponse[]> {
    const res = await this.contract.testInvoke('get_campaigns')
    const valorLegivel = this.formatResponse(res)
    let result: GetCampaignsResponse[] = []
    valorLegivel.forEach((element: any) => {
      result.push(new GetCampaignsResponse(element[0]))
    })
    return result
  }

  async createCampaing(): Promise<string> {
    const involker = await NeonInvoker.init(this.NODE, this.SIGNER)
    const res = await involker.invokeFunction({
      signers: [],
      invocations: [
        {
          scriptHash: this.SCRIPT_HASH,
          operation: 'create_campaign',
          args: [
            {
              type: 'Hash160',
              value: NeonParser.reverseHex(
                NeonParser.strToHexstring('testeScriptHashNovo2')
              ),
            },
          ],
        },
      ],
    })
    return 'true'
  }

  async createVoting(type: string): Promise<string> {
    const involker = await NeonInvoker.init(this.NODE, this.SIGNER)
    const res = await involker.invokeFunction({
      signers: [],
      invocations: [
        {
          scriptHash: this.SCRIPT_HASH,
          operation: 'create_voting',
          args: [
            {
              type: 'String',
              value: type,
            },
          ],
        },
      ],
    })
    return res
  }

  async getVotings(): Promise<GetVotingsResponse[]> {
    const res = await this.contract.testInvoke('get_votings')
    const valorLegivel = this.formatResponse(res)
    let result: GetVotingsResponse[] = []
    valorLegivel.forEach((element: any) => {
      result.push(new GetVotingsResponse(element))
    })
    return result
  }

  async getVotedCampaings(): Promise<string> {
    const involker = await NeonInvoker.init(this.NODE, this.SIGNER)
    const res = await involker.testInvoke({
      signers: [],
      invocations: [
        {
          scriptHash: this.SCRIPT_HASH,
          operation: 'get_account_voting',
          args: [
            {
              type: 'Hash160',
              value: this.SIGNER.scriptHash,
            },
          ],
        },
      ],
    })
    return this.formatResponse(res)
  }

  async getOrgs(): Promise<GetOrganizationResponse[]> {
    const res = await this.contract.testInvoke('get_orgs')
    const valorLegivel = this.formatResponse(res)
    let result: GetOrganizationResponse[] = []
    valorLegivel.forEach((element: any) => {
      result.push(new GetOrganizationResponse(element))
    })
    return result
  }

  async getCampaign(hash: string): Promise<GetCampaignsResponse> {
    const involker = await NeonInvoker.init(this.NODE, this.SIGNER)
    const res = await involker.testInvoke({
      signers: [],
      invocations: [
        {
          scriptHash: this.SCRIPT_HASH,
          operation: 'get_campaign',
          args: [
            {
              type: 'Hash160',
              value: NeonParser.reverseHex(NeonParser.strToHexstring(hash)),
            },
          ],
        },
      ],
    })
    return new GetCampaignsResponse(this.formatResponse(res)[0] || null)
  }

  async getAmountToDonate(): Promise<string> {
    const res = await this.contract.testInvoke('amount_to_donate')
    const valorLegivel = this.formatResponse(res)
    return (valorLegivel / 10 ** 8).toString()
  }

  async vote(hash: string): Promise<string> {
    const involker = await NeonInvoker.init(this.NODE, this.SIGNER)
    const res = await involker.invokeFunction({
      signers: [],
      invocations: [
        {
          scriptHash: this.SCRIPT_HASH,
          operation: 'vote',
          args: [
            {
              type: 'Hash160',
              value: NeonParser.reverseHex(NeonParser.strToHexstring(hash)),
            },
            {
              type: 'Hash160',
              value: this.SIGNER.address,
            },
          ],
        },
      ],
    })
    return res
  }

  async removeVote(hash: string): Promise<string> {
    const involker = await NeonInvoker.init(this.NODE, this.SIGNER)
    const res = await involker.invokeFunction({
      signers: [],
      invocations: [
        {
          scriptHash: this.SCRIPT_HASH,
          operation: 'remove_vote',
          args: [
            {
              type: 'Hash160',
              value: NeonParser.reverseHex(NeonParser.strToHexstring(hash)),
            },
            {
              type: 'Hash160',
              value: this.SIGNER.address,
            },
          ],
        },
      ],
    })
    return res
  }

  private formatResponse(rpcResult: rpc.InvokeResult): any {
    if (rpcResult.stack.length === 0) {
      throw new Error(rpcResult.exception ?? 'unrecognized response')
    }
    return NeonParser.parseRpcResponse(rpcResult.stack[0])
  }

  private async sleep(time: number) {
    return new Promise(resolve => setTimeout(resolve, time))
  }
}
