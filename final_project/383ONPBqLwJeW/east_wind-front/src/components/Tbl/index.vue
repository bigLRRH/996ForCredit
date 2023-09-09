<template>
    <el-form v-if="!tblLoading" :model="editForm" label-width="100px" inline>
        <el-form-item v-for="tblCol in tblColNms" :prop="tblCol" :label="tblCol">
            <el-input v-model="editForm[tblCol]" placeholder="" class="wi-240px" @keyup.enter="handleQuery"></el-input>
        </el-form-item>
    </el-form>
    <el-row class="mb8">
        <el-button type="primary" plain icon="Plus" @click="handleAdd()">新增</el-button>
        <el-button type="primary" icon="Search" @click="handleQuery">查询</el-button>
        <el-button icon="Refresh" @click="handleReset">重置</el-button>
        <el-button type="warning" plain icon="Download" @click="handleExport()">导出为excel</el-button>
    </el-row>
    <el-table v-if="!tblLoading" id="tbl" height="calc(100vh - 362px)" ref="refElTable" v-loading="tblLoading" border stripe
        :data="filteredTblDta" @cell-click="cellClick">
        <el-table-column type="selection" width="50" align="center" />
        <el-table-column v-for="tblCol in tblColNms" :prop="tblCol" :label="tblCol" show-overflow-tooltip :align="'center'">
            <template #default="{ row }">
                <el-input v-if="editGrid[row['id']][tblCol].value && tblCol !== 'id'" v-model="row[tblCol]"
                    @change="handleChange(row)" @blur="editGrid[row['id']][tblCol].value = false" ref="refInput">
                </el-input>
                <span v-else>
                    {{ row[tblCol] }}
                </span>
            </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
            <template #default="{ row }">
                <el-tooltip content="删除" placement="top">
                    <el-button link type="primary" icon="Delete" size="large" @click="handleDelete(row)" />
                </el-tooltip>
            </template>
        </el-table-column>
    </el-table>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted, nextTick } from 'vue'
import ModelService from '@/service/ModelService'
import { ElMessage } from 'element-plus';

const props = defineProps<{
    modelService: ModelService
}>()
const tblLoading = ref<boolean>(true)
const tblColNms = ref<string[]>([])
const tblDta = ref<any[]>([])
const editGrid = reactive<Map<number, Map<string, Ref<boolean>>[]>>(new Map())
const refInput = ref<HTMLInputElement | null>(null)
const editForm = reactive({})
const visibleIds = reactive<boolean[]>([])

// 根据 visibleIds 过滤表格数据
const filteredTblDta = computed(() => {
    return tblDta.value.filter((row, index) => visibleIds[row.id]);
});

// 初始化
async function init() {
    tblLoading.value = true
    tblColNms.value = props.modelService.getCols()
    tblDta.value = await props.modelService.getAll()
    // 根据 tblDta 和 tblColNms 实例化 editGrid 的初始值
    if (tblDta.value === null) return
    tblDta.value.forEach(row => {
        editGrid[row.id] = new Map();
        visibleIds[row.id] = true
        if (tblColNms.value === null) return
        tblColNms.value.forEach(col => {
            editGrid[row.id][col] = ref(false);
        });
    })
    if (tblColNms.value === null) return
    tblColNms.value.forEach(row => {
        editForm[row] = ref(``)
    })
    tblLoading.value = false
}

// 增
function handleAdd() {
    props.modelService.add(editForm)
        .then(async () => {
            ElMessage({ message: '新增成功', type: 'success' })
            init()
        })
}

// 删
function handleDelete(row) {
    elConfirm('delete', `是否确认删除${row}的数据项`)
        .then(() => props.modelService.delete(row))
        .then(async () => {
            ElMessage({ message: '删除成功', type: 'success' })
            init()
        })
        .catch(() => {
            // 取消
        })
}
// 改
function handleChange(row) {
    props.modelService.update(row)
        .then(async () => {
            ElMessage({ message: '修改成功', type: 'success' })
        })
    nextTick(() => {
        if (refInput.value)
            refInput.value[0].blur()
    })
}
// 查
function handleQuery() {
    tblDta.value.forEach(row => {
        visibleIds[row.id] = true
        tblColNms.value.forEach(col => {
            if (editForm[col] !== `` && row[col] != editForm[col]) {
                visibleIds[row.id] = false
            }
        })
    })
    ElMessage({
        message: '查询成功',
        type: 'success'
    })
}

function handleReset() {
    tblColNms.value?.forEach(col => {
        editForm[col] = ``
    })
    tblDta.value.forEach(row => {
        visibleIds[row.id] = true
    })
    ElMessage({
        message: '重置成功',
        type: 'success'
    })
}
// 点击格子展示输入框并聚焦
function cellClick(row, col, cell, event) {
    if (col.property !== undefined) {
        editGrid[row.id][col.property].value = true
    }
    nextTick(() => {
        if (refInput.value)
            refInput.value[0].focus()
    })
}
function handleExport() {
    ElMessage({
        message: '暂不支持导出',
        type: 'warning'
    })
}


onMounted(() => {
    init()
})

</script>

<style scoped></style>