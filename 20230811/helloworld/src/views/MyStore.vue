<template>
    <input type="button" value="++" @click="btnAdd" />
    <br>
    <input type="button" value="--" @click="btnSub" />
    <div>通过计算属性获取state的count值:{{ count }}</div>
    <div>通过store的getters方法获取count值:{{ store.getters.getCount }}</div>
    <div>
        <div>通过user的store获取user的id:{{ store.getters.getId }}</div>
        <input type="button" value="修改user的id" @click="btnModifyUserId">
    </div>

    <div><router-link :to="{ name: 'myStore1' }">myStore1</router-link></div>
    <router-view></router-view>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useStore } from 'vuex';
//执行useStore函数获取store对象
const store = useStore();
// 不能直接修改store.state中数据，为了防止直接修改，使用计算属性
// store.state.count=10;
let count = computed(() => {
    return store.state.count;
})
const btnAdd = () => {
    // 利用store的commit函数，调用mutations中定义函数,目的让所有用store的state的数据全部跟着修改
    // store.commit('addCount', 1);
    // store.dispatch触发actions
    store.dispatch('myAddCount', 1);
}

const btnSub = () => {
    // store.commit('subCount', 1);
    store.dispatch('mySubCount', 1);
}

const btnModifyUserId = () => {
    // store.commit('modifyUserId', 1);
    store.commit('setId', 2);
}
</script>

<style scoped></style>