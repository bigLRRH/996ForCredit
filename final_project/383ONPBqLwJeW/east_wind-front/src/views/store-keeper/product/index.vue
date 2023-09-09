<template>
    <div class="p-10px">
        <tbl :modelService="productService"></tbl>
    </div>
</template>
  
<script setup lang="ts">
import Tbl from '@/components/Tbl/index.vue'
import ProductService from '@/service/store-keeper/ProductService'
let productService = new ProductService()
</script>
  
<style scoped></style>