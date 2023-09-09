<template>
  <component :is="Component" />
</template>

<script setup>
import LoginBase from './login-basic.vue'


const Component = computed(() => LoginBase)
</script>

<style scoped lang="scss"></style>
