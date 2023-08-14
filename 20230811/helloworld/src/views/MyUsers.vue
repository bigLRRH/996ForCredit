<template>
    <el-table :data="users" style="width: 100%;" max-height="250">
        <el-table-column fixed prop="id" label="id" width="300"></el-table-column>
        <el-table-column prop="username" label="用户名" width="300"></el-table-column>
        <el-table-column prop="password" label="密码" width="300"></el-table-column>
        <el-table-column prop="right" label="Operations" width="300">
            <template #default="scope">
                <el-button link type="primary" size="small" @click.prevent="">
                    Remove
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-button class="mt-4" style="width: 100%;" @click="onAddItem">Add Item</el-button>
    <el-pagination background layout="prev,paper,next" :page-size="pageInfo.pageSize" :total="totalCount"
        @current-change="changePageNum">
    </el-pagination>
</template>

<script setup>
import { ref, onMounted, reactive } from "vue";
import { all, page } from '@/api/user';

onMounted(() => {
    // all().then(res => {
    //     users.value = res.data
    // })
    myPage();
})

const users = ref([
    { id: 1, username: 'tom', password: '99999' },
    { id: 1, username: 'jim', password: '00000' }
]);

const pageInfo = reactive({ pageNum: 1, pageSize: 2 })
const totalCount = ref(10);
const myPage = () => {
    page(pageInfo).then(res => {
        // console.log(res.data);
        console.log(res.data.total);
        users.value = res.data.list;
        totalCount.value = res.data.total;
    });
};

const changePageNum = (val) => {
    console.log(val);
    pageInfo.pageNum = val;
    myPage();
}
</script>

<style scoped></style>