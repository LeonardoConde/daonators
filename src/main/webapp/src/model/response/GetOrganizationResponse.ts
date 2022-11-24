import {NeonParser} from '@cityofzion/neon-parser'

export class GetOrganizationResponse {
  private key: string | null = null
  private value: string | null = null
  constructor(keyValue: String[2] | null) {
    if (keyValue != null) {
      this.key =
        NeonParser.base64ToUtf8(NeonParser.strToBase64(keyValue[1])) || ''
      this.value =
        NeonParser.base64ToUtf8(NeonParser.strToBase64(keyValue[0])) || ''
    }
  }

  get name() {
    return this.key || ''
  }

  get hash() {
    return this.value || ''
  }
}
