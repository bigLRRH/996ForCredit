<template>
    <el-form ref="ruleFormRef" :model="userForm" :rules="rules">
        <!-- prop的值,表单数据的key值，rules定义的规则的key值，三者保持一致 -->
        <el-form-item label="用户名" prop="username">
            <el-input v-model="userForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input v-model="userForm.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm">登录</el-button>
        </el-form-item>
    </el-form>
</template>

<script setup>
import { ref, reactive } from 'vue';
import { useStore } from 'vuex';
import { login } from '@/api/user'

const userForm = reactive({ username: "", password: "" })
const rules = reactive({
    username: [
        { required: true, message: '用户名不能为空', trigger: blur },
        { min: 3, max: 10, message: '用户名长度3~10个字符', trigger: blur }
    ],
    password: [
        { required: true, message: '密码不能为空', trigger: blur },
        { min: 3, max: 10, message: '密码长度3~10个字符', trigger: blur }
    ]
})

const ruleFormRef = ref()
const submitForm = () => {
    ruleFormRef.value.validate((valid) => {
        if (valid) {
            // 校验通过
            // console.log('submit!');
            // const url = '/api/user/login';
            // const data = qs.stringify(userForm);
            // console.log("data: " + data);
            // axios请求后端
            // axios({
            //     url,
            //     method: 'post',
            //     header: { "Content-Type": "application/x-www-form-urlencoded;charset=utf-8" },
            //     data
            // }).then((response) => {
            //     if (response.data.state == 0) {
            //         const user = response.data.data;
            //         console.log(user);
            //         store.commit("saveUser", user);
            //     } else {
            //         alert(response.data.message);
            //     }
            // }).catch((e) => {
            //     console.log(e);
            // });
            login(userForm).then((response) => {
                console.log(response);
                const user = response.data;
                store.commit("saveUser", user);
            })
        } else {
            console.log('error submit!!');
            return false;
        }
    });
}
const store = useStore();
</script>

<style scoped></style>