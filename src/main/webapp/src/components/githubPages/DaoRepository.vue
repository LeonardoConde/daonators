<template>
  <div class="verti">
    <div class="horiz items-center-center">
      <i class="fab fa-github text-2xl" />
      <a class="ml-2 text-lg" :href="$t('github.projectLink')" target="_blank">
        {{ $t('github.project') }}
      </a>
    </div>
    <div class="horiz items-center-center mt-6">
      <i class="fas fa-file-contract text-2xl" />
      <a
        class="ml-2 text-lg"
        :href="$t('github.contractDoraLink')"
        target="_blank"
      >
        {{ $t('github.contractDora') }}
      </a>
    </div>
    <div class="horiz items-center-center mt-6">
      <i class="fas fa-file-code text-2xl" />
      <a
        class="ml-2 text-lg"
        :href="$t('github.contractsLink')"
        target="_blank"
      >
        {{ $t('github.contracts') }}
      </a>
    </div>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator'

@Component
export default class DaoRepository extends Vue {}
</script>

<style lang="scss" scoped></style>
