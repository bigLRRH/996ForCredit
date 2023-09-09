<template>
  <div class="p-10px">
    <tbl :modelService="storeService"></tbl>
  </div>
</template>
  
<script setup lang="ts">
import Tbl from '@/components/Tbl/index.vue'
import StoreService from '@/service/store-keeper/StoreService'
let storeService = new StoreService()
</script>
  
<style scoped></style>