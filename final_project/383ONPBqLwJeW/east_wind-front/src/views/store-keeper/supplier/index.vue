<template>
    <div class="p-10px">
        <tbl :modelService="supplierService"></tbl>
    </div>
</template>
    
<script setup lang="ts">
import Tbl from '@/components/Tbl/index.vue'
import SupplierService from '@/service/store-keeper/SupplierService'
let supplierService = new SupplierService()
</script>
    
<style scoped></style>