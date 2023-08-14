import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// 导入element-plus组件
import ElementPlus from 'element-plus'
// 导入element-plus的样式
import 'element-plus/dist/index.css'

import GlobalComponentA from '@/components/GlobalComponentA';
const app = createApp(App);
// 注册全局组件，组件名称和组件对象
// 名称用驼峰，使用时可以用驼峰和短中线
app.component('GlobalComponentA', GlobalComponentA);
// app.component('global-component-a', GlobalComponentA);

app.use(ElementPlus);
app.use(store).use(router).mount('#app')
// console.log(app);