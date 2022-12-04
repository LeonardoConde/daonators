import {NeonParser} from '@cityofzion/neon-parser'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'

export class GetOrganizationResponse {
  private key: string | null = null
  value: string | null = null
  isSelected: Boolean = false
  constructor(keyValue: String[2] | null) {
    if (keyValue != null) {
      this.key =
        NeonParser.base64ToUtf8(NeonParser.strToBase64(keyValue[1])) || ''
      this.value =
        NeonParser.base64ToUtf8(NeonParser.strToBase64(keyValue[0])) || ''
    }
  }

  toggleSelect() {
    this.isSelected = !this.isSelected
  }

  get name() {
    return this.key || ''
  }

  get hash() {
    return this.value || ''
  }
}
