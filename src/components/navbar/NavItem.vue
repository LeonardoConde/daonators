<template>
  <div>
    <div v-if="!isMobile">
      <router-link :to="item.href"> {{ item.title }} </router-link>
    </div>
    <div v-else>
      <a :href="item.href"> {{ item.title }} </a>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Mixins, Prop} from 'vue-property-decorator'
import {MixinScreenSize} from '@/components/mixins/MixinScreenSize'
import {NavItemLink} from '@/model/NavItemLink'

@Component
export default class NavItem extends Mixins(MixinScreenSize) {
  @Prop({type: NavItemLink, required: true}) item!: NavItemLink
}
</script>

<style scoped></style>
