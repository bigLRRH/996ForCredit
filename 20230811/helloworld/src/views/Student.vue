<template>
    <h1>{{ title }}</h1>
    <input type="button" value="sendGet1" @click="sendGet1" />
    <input type="button" value="sendGet2" @click="sendGet2" />
    <input type="button" value="sendPost1" @click="sendPost1" />
    <input type="button" value="sendPost2" @click="sendPost2" />
    <input type="button" value="sendPost3" @click="sendPost3" />
    <table border="1px" cellspacing="0">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>email</th>
        </tr>
        <tr v-for="student in students" :key="student.id">
            <td>{{ student.id }}</td>
            <td>{{ student.name }}</td>
            <td>{{ student.age }}</td>
            <td>{{ student.email }}</td>
        </tr>
    </table>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import qs from 'qs';
const title = ref('请求后端api显示学生的数据');
const students = ref([
    {
        "id": 1007,
        "name": "常秀兰",
        "age": 26,
        "email": "t@t.com"
    },
    {
        "id": 1008,
        "name": "金军",
        "age": 27,
        "email": "t@t.com"
    },
    {
        "id": 1009,
        "name": "孟洋",
        "age": 28,
        "email": "t@t.com"
    },
    {
        "id": 1010,
        "name": "徐明",
        "age": 29,
        "email": "t@t.com"
    }
]);
const sendGet1 = () => {
    // 请求api 处理结果集
    // axios 异步请求api (异步执行不会等待结果，直接运行后面的代码，不阻塞代码)
    // 由于是异步执行，then表示成功获取结果就会回调then()里面的函数
    // 有可能axios过程，网络不通就回调catch函数

    axios({
        url: 'http://rap2api.taobao.org/app/mock/238982/students',
        method: 'get',
        params: { 'a': 1, 'b': 2 }
    }).then((response) => {
        // console.log(response);
        // if (response.status==200) {}
        console.log(response.data);
        students.value = response.data.students;
    }).catch((e) => {
        console.log(e);
    });
    console.log("代码在axios代码之后")

}

const sendGet2 = () => {
    const url = 'http://rap2api.taobao.org/app/mock/238982/students';
    const params = { 'a': 1, 'b': 2 };
    axios
        .get(url, /* 参数一定要有{}*/{ params })
        .then((response) => {
            students.value = response.data.students;
        })
        .catch((e) => {
            console.log(e);
        });
}

const sendPost1 = () => {
    axios({
        url: 'http://rap2api.taobao.org/app/mock/285595/post-students',
        method: 'post',
        data: {
            'a': 1,
            'b': 2
        }
    }).then((response) => {
        students.value = response.data.students;
    }).catch((e) => {
        console.log(e);
    })
}

const sendPost2 = () => {
    // post请求 数据是k1=v1&k2=v2 请求头 content-type为application/x-www-from-urlencoded
    const data = { a: 1, b: 2 };
    axios({
        url: 'http://rap2api.taobao.org/app/mock/285595/post-students',
        method: 'post',
        // qs.stringify() 把对象转成a=1&b=2
        data: qs.stringify(data),
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
        // headers: {
        //     'Content-Type': 'application/x-www-urlencoded'
        // }
    }).then((response) => {
        students.value = response.data.students;
    }).catch((e) => {
        console.log(e);
    })

}

const sendPost3 = () => {
    const url = 'http://rap2api.taobao.org/app/mock/285595/post-students';
    const data = qs.stringify({ a: 1, b: 2 });
    const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
    axios
        .post(url, data, { headers })
        .then((response) => {
            students.value = response.data.students;
        })
        .catch((e) => {
            console.log(e);
        });
}

</script>

<style scoped></style>