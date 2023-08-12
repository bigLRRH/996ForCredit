<template>
    <h1>{{ message }}</h1>
    <h3>{{ childMessage }}</h3>
    <h3>{{ childMessage1 }}</h3>

    <input type="button" value="子组件按钮" @click="btnClick" />

    <br />
    <input type="button" v-for="category in categories" :value="category.name" @click="btnCategoryClick(category)">
</template>

<!-- <script>
import { ref } from 'vue';
export default {
    name: 'ComponentA',
    props: ['childMessage'],
    setup() {
        const message = ref('Component A');
        return {
            message
        }
    }
}
</script> -->

<script setup>
import { ref, defineProps,defineEmits } from 'vue';

const props = defineProps("childMessage", "childMessage1");

const message = ref('Component A');

const btnClick = () => {
    // 无法修改，prop是只读的
    props.childMessage = "子组件修改" + new Date().toString();
    console.log(props.childMessage);
    console.log(props.childMessage1);
}

const categories = ref([
    { id: 1, name: "Guernsey" },
    { id: 2, name: "Northern Ireland" },
    { id: 3, name: "Scotland" },
    { id: 4, name: "Wales" }
])
// 自定义事件 defineEmits([字符串数组])
const emits = defineEmits(['itemClick']);
const btnCategoryClick = (category) => {
    console.log(category);
    //触发自定义事件，传入自定义事件名称和数据
    emits('itemClick', category);
}
</script>

<style scoped></style>