<template>
  <div class="view">
    <header class="header">
      <h1 class="header__title">
        {{ $t('resource.User') }}
      </h1>
    </header>

    <section class="relative">
      <await name="getUser" class="px-4 py-8">
        <form class="container card w-full lg:w-160" @submit.prevent="persist">
          <div class="mb-8 grid md:grid-cols-2 gap-4">
            <render-schema
              v-for="field in schema.allFields"
              v-model="user"
              :schema="schema"
              :field="field"
              :key="field"
            />
          </div>

          <await name="persistUser" class="items-center-center">
            <button
              type="submit"
              class="h-12 px-20 btn btn--contrast bg-secondary"
            >
              {{ $t('app.submit') }}
            </button>
          </await>
        </form>
      </await>
    </section>
  </div>
</template>

<script lang="ts">
import {Component, Prop, Watch, Provide, Vue} from 'vue-property-decorator'
import {User} from '@/model/resource/User'
import {InputUserSchema} from '@/schema/resource/User/InputUserSchema'

@Component
export default class PersistUserView extends Vue {
  @Prop() id?: string

  @Provide('validator') validator = this.$validator

  schema = new InputUserSchema()
  user = new User()

  async created() {
    await this.populate()
  }

  async populate() {
    const id = Number(this.id) || null

    if (id) {
      await this.user.getUser(id)
    }

    this.$await.done('getUser')
  }

  async persist() {
    const isValid = await this.validator.validateAll()

    if (!isValid) {
      this.$toast.abort('system.error.validation')
    }

    await this.user.persistUser()
    this.$toast.success('system.success.persist')
    await this.$nav.push('/user/list')
  }
}
</script>
