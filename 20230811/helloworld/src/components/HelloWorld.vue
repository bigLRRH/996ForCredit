<template>
  <h2>{{ message }}</h2>
</template>

<!-- <script>
import {ref} from 'vue';

export default{
  name: 'HelloWorld',
  setup() {
    const message = ref('Welcome to Your Vue.js App');
    return {
      message
    }
  }
}
</script> -->

<script setup>
import { ref } from 'vue';

const message = ref('HelloWorld 局部组件');
</script>


<style scoped></style>