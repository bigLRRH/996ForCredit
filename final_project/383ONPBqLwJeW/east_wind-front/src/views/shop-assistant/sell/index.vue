<template>
    <div class="p-10px">
        <el-form v-if="!tblLoading" :model="editForm" label-width="100px" inline>
            <el-form-item v-for="tblCol in tblColNms" :prop="tblCol" :label="tblCol">
                <el-input v-model="editForm[tblCol]" placeholder="" class="wi-240px"></el-input>
            </el-form-item>
        </el-form>
        <el-row class="mb8">
            <el-button type="primary" plain icon="Plus" @click="handleSell()">销售</el-button>
        </el-row>
        <tbl :key="tblKey" :modelService="sellService"></tbl>
    </div>
</template>
  
<script setup lang="ts">
import Tbl from '@/components/Tbl/index.vue'
import SellService from '@/service/shop-assistant/SellService'
import { ElMessage } from 'element-plus';
let sellService = new SellService()
const tblColNms = ref<string[]>(sellService.getCols())
const editForm = reactive({})
const tblLoading = ref<boolean>(true)
const tblKey = ref<number>(0)
function refreshTbl() {
    tblKey.value++
}
function handleSell() {
    sellService.sell(editForm).then(() => {
        ElMessage.success('销售成功')
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