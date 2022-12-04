import {ContractVotingType} from '@/model/contractObjects/ContractVotingType'
import {NeonParser} from '@cityofzion/neon-parser'

export class GetVotingsResponse {
  campaignHashList: string[] = []
  campaignType: ContractVotingType | null = null

  constructor(keyValue: any[] | null) {
    if (keyValue != null) {
      keyValue[0].forEach((element: any) => {
        this.campaignHashList.push(
          NeonParser.base64ToUtf8(NeonParser.strToBase64(element)) as string
        )
      })
      this.campaignType = new ContractVotingType(keyValue[1])
    }
  }
}
