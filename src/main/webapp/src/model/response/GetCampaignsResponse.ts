import {NeonParser} from '@cityofzion/neon-parser'

export class GetCampaignsResponse {
  private key: string | null = null
  private value: string | null = null
  hasVoted: boolean = false
  constructor(keyValue: String[2] | null) {
    if (keyValue != null) {
      this.key =
        NeonParser.base64ToUtf8(NeonParser.strToBase64(keyValue[0])) || ''
      this.value =
        NeonParser.base64ToUtf8(NeonParser.strToBase64(keyValue[1])) || ''
    }
  }

  get hash() {
    return this.key || ''
  }

  get nome() {
    return this.value || ''
  }
}
