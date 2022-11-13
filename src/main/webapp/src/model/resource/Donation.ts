/**
 * Donation
 * @author Simpli CLI generator
 */
import {$} from '@/facade'
import {Request, ResponseSerialize} from '@simpli/serialized-request'
import {IResource} from '@simpli/resource-collection/dist/types/IResource'
import {Campaing} from '@/model/resource/Campaing'
import {Organization} from '@/model/resource/Organization'
import {DonationCollection} from '@/model/collection/DonationCollection'

/* TODO: review generated class */
export class Donation implements IResource {
  idDonationPk: number = 0

  @ResponseSerialize(Campaing)
  campaing: Campaing | null = null

  @ResponseSerialize(Organization)
  organization: Organization | null = null

  transactionHash: string | null = null
  gasAmount: number | null = null

  get $id() {
    return this.idDonationPk
  }
  set $id(val) {
    this.idDonationPk = val
  }
  get $tag() {
    return String(this.$id)
  }

  get idCampaingFk() {
    if (!this.campaing) return 0
    return this.campaing.$id
  }
  set idCampaingFk(val) {
    if (!this.campaing) this.campaing = new Campaing()
    this.campaing.$id = val
  }

  get idOrganizationFk() {
    if (!this.organization) return 0
    return this.organization.$id
  }
  set idOrganizationFk(val) {
    if (!this.organization) this.organization = new Organization()
    this.organization.$id = val
  }

  /**
   * Lists the instances of Donation
   */
  static async listDonation(params: any) {
    return await Request.get(`/client/donation`, {params})
      .name('listDonation')
      .as(DonationCollection)
      .getData()
  }

  /**
   * Persists a new instance of Donation. Use ID = 0 to create a new one,
   * or ID > 0 to update a current one
   */
  async persistDonation() {
    return await Request.post(`/client/donation`, this)
      .name('persistDonation')
      .asNumber()
      .getData()
  }

  /**
   * Lists the instances of Donation to export as a file
   */
  static async listExportDonation(params: any) {
    return await Request.get(`/client/donation/export`, {params})
      .name('listExportDonation')
      .as(DonationCollection)
      .getData()
  }

  /**
   * Gets a instance of a given ID of Donation
   */
  async getDonation(id1: number, id2: number, id3: number) {
    return await Request.get(`/client/donation/${id1}/${id2}/${id3}`)
      .name('getDonation')
      .as(this)
      .getData()
  }
}
