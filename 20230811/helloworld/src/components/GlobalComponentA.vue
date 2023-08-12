<!-- 显示区，写html -->
<template>
    <h1>{{ message }}</h1>
</template>

<!-- <script>
import { ref } from 'vue';
export default {
    // 组件名称
    name: 'GlobalComponentA',
    // 组合式api
    setup() {
        const message = ref('GlobalComponentA');
        return {
            message
        }
    }
}
</script> -->

<script setup>
import { ref } from 'vue';

const message = ref('GlobalComponentA 全局组件');
</script>

<!-- 样式 -->
<style scoped></style>