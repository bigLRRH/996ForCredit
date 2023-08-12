<template>
  <!-- <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div> -->
  <div>message:{{ message }}</div>
  <!-- 使用全局组件 -->
  <GlobalComponentA></GlobalComponentA>
  <!-- 使用局部组件 -->
  <HelloWorld></HelloWorld>

  <ComponentA :childMessage="parentMessage" :childMessage1="parentMessage" @itemClick="callback"></ComponentA>
  <h4 class="div1">parentMessage:{{ parentMessage }}</h4>
  <input type="button" value="按钮" @click="btnClick" />
</template>

<!-- <script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script> -->

<script setup>
import { ref } from 'vue';
import HelloWorld from '@/components/HelloWorld.vue';
import ComponentA from '@/components/ComponentA.vue';

const message = ref('我是homeView');
const parentMessage = ref("HomeView的parentMessage传入子组件")
const btnClick = () => {
  parentMessage.value = "HomeView的parentMessage变化了" + new Date();
}
const callback = (data) => {
  console.log(`父组件接收数据id=${data.id},name=${data.name}`);
  message.value = `id=${data.id},name=${data.name}`;
}
</script>

<style scoped>
.div1 {
  color: red;
}
</style>