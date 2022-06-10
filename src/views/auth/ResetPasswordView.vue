<template>
  <div class="bg-black-100">
    <div class="container verti min-h-screen items-center-center">
      <img src="@/assets/img/logo.png" class="w-32 h-32 mb-4" alt="logo" />

      <div class="w-full md:w-80 p-4 bg-white shadow-md rounded-lg">
        <form @submit.prevent="submit">
          <await name="resetPassword" :spinnerScale="1.5">
            <div class="mb-4 font-semibold text-lg text-center uppercase">
              {{ $t('view.resetPassword.title') }}
            </div>

            <div v-for="(field, i) in schema.allFields" :key="i">
              <render-schema
                v-model="request"
                :schema="schema"
                :field="field"
                class="mb-4"
              />
            </div>

            <button
              class="w-full h-12 btn btn--contrast bg-primary"
              type="submit"
            >
              {{ $t('view.resetPassword.submit') }}
            </button>
          </await>
        </form>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import {ResetPasswordRequest} from '@/model/request/ResetPasswordRequest'
import {InputResetPasswordRequestSchema} from '@/schema/request/ResetPasswordRequest/InputResetPasswordRequestSchema'

@Component
export default class ResetPasswordView extends Vue {
  @Prop({type: [String, Number]}) hash?: string

  schema = new InputResetPasswordRequestSchema()
  request = new ResetPasswordRequest()

  created() {
    this.request.hash = this.hash ?? null
  }

  async submit() {
    await this.request.resetPassword()
    this.$toast.success('system.success.resetPassword')
    await this.$nav.push('/sign-in')
  }
}
</script>
