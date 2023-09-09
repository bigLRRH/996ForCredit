<template>
    <div class="p-10px">
        <el-form v-if="!tblLoading" :model="editForm" label-width="100px" inline>
            <el-form-item v-for="tblCol in tblColNms" :prop="tblCol" :label="tblCol">
                <el-input v-model="editForm[tblCol]" placeholder="" class="wi-240px"></el-input>
            </el-form-item>
        </el-form>
        <el-row class="mb8">
            <el-button type="primary" plain icon="Plus" @click="handleSupply()">进货</el-button>
        </el-row>
        <tbl :key="tblKey" :modelService="supplyService"></tbl>
    </div>
</template>
    
<script setup lang="ts">
import Tbl from '@/components/Tbl/index.vue'
import SupplyService from '@/service/store-keeper/SupplyService'
import { ElMessage } from 'element-plus';
let supplyService = new SupplyService()
const tblColNms = ref<string[]>(supplyService.getCols())
const editForm = reactive({})
const tblLoading = ref<boolean>(true)
const tblKey = ref<number>(0)
function refreshTbl() {
    tblKey.value++
}
function handleSupply() {
    supplyService.supply(editForm).then(() => {
        ElMessage.success('进货成功')
        refreshTbl()
    })
}
onMounted(() => {
    tblLoading.value = true
    tblColNms.value.forEach(row => {
        editForm[row] = ref(``)
    })
    tblLoading.value = false
})
</script>
    
<style scoped></style>