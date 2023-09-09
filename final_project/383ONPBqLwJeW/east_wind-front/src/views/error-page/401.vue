<template>
    <div class="type4">
        <div class="type1">Oops!</div>
        <div class="type1">
            401 Unauthorized
        </div>
        <div class="type2">
            前面的区域以后再来探索吧
        </div>
    </div>
</template>

<script setup lang="ts">

</script>

<style scoped>
.type1 {
    font-size: 48px;
    font-weight: bold;
    color: #ff3366;
    text-align: center;
    text-transform: uppercase;
    letter-spacing: 4px;
    margin-bottom: 20px;
    animation: neon-glow 1.5s ease-in-out infinite alternate;
}

@keyframes neon-glow {
    0% {
        text-shadow: 0 0 5px #ff3366, 0 0 20px #ff3366, 0 0 35px #ff3366;
    }

    100% {
        text-shadow: 0 0 10px #ff3366, 0 0 30px #ff3366, 0 0 50px #ff3366;
    }
}

.type2 {
    font-size: 48px;
    /* 标题字体大小 */
    font-weight: bold;
    /* 标题字体粗细 */
    text-align: center;
    /* 标题居中对齐 */
    margin-bottom: 20px;
    /* 标题下方留白 */
    color: aliceblue
}

/* 定义闪动动画 */
@keyframes flicker {
    0% {
        background-color: red;
    }

    25% {
        background-color: green;
    }

    50% {
        background-color: blue;
    }

    75% {
        background-color: green;
    }

    100% {
        background-color: red;
    }
}

/* 应用闪动动画到背景图片 */
.type4 {
    height: 2000px;
    animation: flicker 2s infinite;
}
ssss</style>