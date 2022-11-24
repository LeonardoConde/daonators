<template>
  <div class="verti items-center-center my-6">
    <div class="text-2xl">{{ $t('github.title') }}</div>
    <dao-repository class="my-6" />
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'
import DaoRepository from '@/components/githubPages/DaoRepository.vue'
@Component({
  components: {DaoRepository},
})
export default class githubPages extends Vue {}
</script>

<style lang="scss" scoped></style>
