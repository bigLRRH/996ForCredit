<template>
    <div class="my">
        <h3>{{ title }}</h3>
        <div>{{ queryParam }}</div>
    </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue';
// userRoute 为了接收url中参数
import { useRoute } from 'vue-router';
const title = ref('注册');
// 执行useRoute函数生成一个对象
const route = useRoute();
const queryParam = reactive({});
// 钩子函数
onMounted(() => {
    // route的query
    console.log(route.query);
    // 
    queryParam.id = route.query.id;
    queryParam.count = route.query.count;
})
</script>

<style scoped>
.my {
    width: 400px;
    height: 400px;
    background-color: red;
    /* 自动居中 */
    margin: 0 auto;
}
</style>