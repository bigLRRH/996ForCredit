<template>
    <h3>{{ title }}</h3>
    <div class="div1">获取store中定义count值{{ store.getters.getCount }}</div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useStore } from 'vuex';
const title = '我是MyStore1';
const store = useStore();
</script>

<style scoped>
.div1 {
    width: 500px;
    height: 500px;
    border: 1px solid red;
    margin: 0 auto;
}
</style>