<template>
    <h1>{{ title }}</h1>
    <!-- 注册和登录 -->
    <!-- <router-link to="/myHome/register">注册</router-link> -->
    <!-- <router-link :to="{ path: '/myHome/register', query: queryParam }">注册</router-link> -->
    <router-link :to="{ name: 'register', query: queryParam }">注册</router-link>
    |
    <!-- <router-link to="/myHome/login">登录</router-link> -->
    <router-link :to="{ name: 'login', params: params }">登录</router-link>
    <div>
        <input type="button" value="跳转注册" @click="jumpRegister" />
        <br />
        <input type="button" value="跳转登录" @click="jumpLogin" />
    </div>
    <!-- 显示 view-->
    <router-view></router-view>
</template>

<script setup>
import { ref, reactive } from 'vue';
// useRouter是为了动态跳转（一般在触发主动跳转）
import { useRouter } from 'vue-router';
const title = ref('主页myHome');
const queryParam = reactive({ id: 1, count: 10 });
// 参数的配置路由要与path保持一致(相当于restful格式的参数 http://localhost:8080/myHome/login/%E5%BC%A0%E4%B8%89/123456)
const params = reactive({
    username: '张三',
    password: '123456'
});
// 执行useRouter返回一个对象
const router = useRouter();
const jumpRegister = () => {
    // router的push函数主动跳转
    // router.push({ path: "/myHome/register", query: queryParam });
    router.push({ name: "register", query: queryParam });
}
const jumpLogin = () => {
    router.push({ name: "login", params: params });
}

</script>

<style scoped>
.aa {
    width: 100%;
    margin: 0 auto;
}
</style>