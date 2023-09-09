<template>
  <div class="p-10px">
    <tbl :modelService="userService"></tbl>
  </div>
</template>

<script setup lang="ts">
import Tbl from '@/components/Tbl/index.vue'
import WarehouseService from '@/service/store-keeper/WarehouseService'
const userService: WarehouseService = new WarehouseService()
</script>

<style scoped>

</style>