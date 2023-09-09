import { createRouter, createWebHashHistory } from 'vue-router'
import Layout from '@/layout/index.vue'
/* Router Modules */

export const constantRoutes = [
    {
        path: '/redirect',
        component: Layout,
        hidden: true,
        children: [
            {
                path: '/redirect/:path(.*)',
                component: () => import('@/views/redirect')
            }
        ]
    },
    {
        path: '/login',
        component: () => import('@/views/login/index.vue'),
        hidden: true
    },
    {
        path: '/404',
        component: () => import('@/views/error-page/404.vue'),
        hidden: true
    },
    {
        path: '/401',
        component: () => import('@/views/error-page/401.vue'),
        hidden: true
    },
    {
        path: '/',
        component: Layout,
        redirect: '/index',
        children: [
            {
                path: 'index',
                name: 'Dashboard',
                component: () => import('@/views/dashboard/index.vue'),
                //using el svg icon, the elSvgIcon first when at the same time using elSvgIcon and icon
                meta: { title: 'Dashboard', elSvgIcon: 'Fold', affix: true }
            }
        ]
    },
    {
        path: '/shop-assistant',
        component: Layout,
        redirect: '/shop-assistant/sell',
        children: [
            {
                path: 'sell',
                name: 'sell',
                component: () => import('@/views/shop-assistant/sell/index.vue'),
                meta: { title: '销售管理', elSvgIcon: 'Fold', affix: true }
            }
        ]
    },
    {
        path: '/store-keeper',
        component: Layout,
        redirect: '/store-keeper/product',
        children: [
            {
                path: 'product',
                name: 'product',
                component: () => import('@/views/store-keeper/product/index.vue'),
                meta: { title: '商品管理', elSvgIcon: 'Fold', affix: true }
            }
        ]
    },
    {
        path: '/store-keeper',
        component: Layout,
        redirect: '/store-keeper/store',
        children: [
            {
                path: 'store',
                name: 'store',
                component: () => import('@/views/store-keeper/store/index.vue'),
                meta: { title: '库存管理', elSvgIcon: 'Fold', affix: true }
            }
        ]
    },
    {
        path: '/store-keeper',
        component: Layout,
        redirect: '/store-keeper/supplier',
        children: [
            {
                path: 'supplier',
                name: 'supplier',
                component: () => import('@/views/store-keeper/supplier/index.vue'),
                meta: { title: '供应商管理', elSvgIcon: 'Fold', affix: true }
            }
        ]
    },
    {
        path: '/store-keeper',
        component: Layout,
        redirect: '/store-keeper/supply',
        children: [
            {
                path: 'supply',
                name: 'supply',
                component: () => import('@/views/store-keeper/supply/index.vue'),
                meta: { title: '进货管理', elSvgIcon: 'Fold', affix: true }
            }
        ]
    },
    {
        path: '/store-keeper',
        component: Layout,
        redirect: '/store-keeper/warehouse',
        children: [
            {
                path: 'warehouse',
                name: 'warehouse',
                component: () => import('@/views/store-keeper/warehouse/index.vue'),
                meta: { title: '仓库管理', elSvgIcon: 'Fold', affix: true }
            }
        ]
    },
    {
        path: '/system',
        component: Layout,
        redirect: '/system/user',
        children: [
            {
                path: 'user',
                name: 'user',
                component: () => import('@/views/system/user/index.vue'),
                meta: { title: '用户管理', elSvgIcon: 'Fold', affix: true }
            }
        ]
    }

]

//角色和code数组动态路由
export const roleCodeRoutes = [

]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
    // 404 page must be placed at the end !!!
    { path: '/:catchAll(.*)', name: 'CatchAll', redirect: '/404', hidden: true }
]

const router = createRouter({
    history: createWebHashHistory(),
    scrollBehavior: () => ({ top: 0 }),
    routes: constantRoutes
})


export default router