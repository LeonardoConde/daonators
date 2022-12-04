import {NeonParser} from '@cityofzion/neon-parser'

export class ContractVotingType {
  id: number = 0
  name: String | null = null

  constructor(keyValue: any[] | null) {
    if (keyValue != null) {
      this.id = keyValue[0] as number
      this.name =
        NeonParser.base64ToUtf8(NeonParser.strToBase64(keyValue[1])) || ''
    }
  }
}
