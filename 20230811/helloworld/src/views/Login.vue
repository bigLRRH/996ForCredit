<template>
    <div class="my">
        <h3>{{ title }}</h3>
        <div>{{ params }}</div>
    </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue';
import { useRoute } from 'vue-router';
const title = ref('登录');
const params = reactive({});
const route = useRoute();
onMounted(() => {
    params.username = route.params.username;
    params.password = route.params.password;
})
</script>

<style scoped>
.my {
    width: 400px;
    height: 400px;
    background-color: blue;
    /* 自动居中 */
    margin: 0 auto;
}
</style>