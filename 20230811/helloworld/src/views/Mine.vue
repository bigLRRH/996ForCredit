<template>
    <div class="div1">
        <h1>info:{{ info }}</h1>
    </div>
</template>

<script setup>
import { ref } from 'vue';
const info = ref("我的")

</script>


<style scoped>
.div1 {
    width: 400px;
    height: 400px;
    background-color: blue;
}
</style>