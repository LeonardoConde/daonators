<template>
  <await name="authenticate" spinner="FadeLoader">
    <main class="min-h-screen">
      <sidebar class="z-20 lg:h-full" @toggle="toggleEvent" />

      <transition name="fade-down" mode="out-in">
        <router-view v-if="authorized" class="router-view" :class="viewClass" />
      </transition>
    </main>
  </await>
</template>

<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator'
import Sidebar from '@/components/Sidebar.vue'

@Component({
  components: {Sidebar},
})
export default class AuthLayout extends Vue {
  authorized = false
  collapsed = true

  get viewClass() {
    return {
      'router-view--collapsed': this.collapsed,
    }
  }

  async mounted() {
    await this.$auth.authenticate()
    this.authorized = true
  }

  toggleEvent(menu: boolean) {
    this.collapsed = menu
  }
}
</script>

<style lang="scss" scoped>
.router-view {
  @apply transition pt-12 pl-0 weight-1;

  @screen lg {
    @apply pt-0 pl-20;
  }

  &.router-view--collapsed {
    @screen lg {
      @apply pl-64;
    }
  }
}
</style>
