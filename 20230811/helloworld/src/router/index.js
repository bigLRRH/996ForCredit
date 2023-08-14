import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Main from '@/views/Main.vue';
import Message from '@/views/Message.vue';
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/main',
    name: 'main',
    component: Main
  },
  {
    path: '/message',
    name: 'message',
    component: Message
  },
  {
    path: '/mine',
    name: 'mine',
    component: () => import('@/views/Mine.vue')
  },
  {
    path: '/myHome',
    name: 'myHome',
    component: () => import('@/views/MyHome.vue'),
    // 配置子路由(嵌套路由)
    children: [
      {
        // :username 表示参数占位
        path: '/myHome/login/:username/:password',
        name: 'login',
        component: () => import('@/views/Login.vue')
        // children:[]
      },
      {
        path: '/myHome/register',
        name: 'register',
        component: () => import('@/views/Register.vue')
      }
    ]
  },
  {
    path: '/student',
    name: 'student',
    component: () => import('@/views/Student.vue')
  },
  {
    path: '/myStore',
    name: 'myStore',
    component: () => import('@/views/MyStore.vue'),
    children: [
      {
        path: '/myStore1',
        name: 'myStore1',
        component: () => import('@/views/MyStore1.vue')
      }
    ]
  },
  {
    path: '/myElement',
    name: 'myElement',
    component: () => import('@/views/MyElement.vue')
  },
  {
    path: '/myLogin',
    name: 'myLogin',
    component: () => import('@/views/MyLogin.vue')
  },
  {
    path:'/myUsers',
    name:'myUsers',
    component: () => import('@/views/MyUsers.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
