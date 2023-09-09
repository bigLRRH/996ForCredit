<template>
  <div class="p-10px">
    <tbl :modelService="userService"></tbl>
  </div>
</template>

<script setup lang="ts">
import Tbl from '@/components/Tbl/index.vue'
import UserService from '@/service/system/UserService';
const userService: UserService = new UserService()
</script>

<style scoped></style>