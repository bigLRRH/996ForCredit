import request from '@/utils/request'

export function login(data) {
    return request({
        url: '/api/user/login',
        //post请求
        method: 'post',
        data
    })
}

export function logout(params) {
    return request({
        url: '/api/user/logout',
        //get请求
        method: 'get',
        params
    })
}

export function getUsers(data) {
    return request({
        //设置请求数据格式为json
        headers: { "Content-Type": "application/json;charset=UTF-8" },
        url: '/api/user/logout',
        method: 'post',
        data
    })
}

//上传图片
export function uploadImage(data) {
    return request({
        //设置请求数据格式为multipart/form-data
        headers: { "Content-Type": "multipart/form-data;charset=UTF-8" },
        url: '/api/user/image/upload',
        method: 'post',
        data
    })
}

export function all(data) {
    return request({
        url: '/api/user/all',
        //post请求
        method: 'post',
    })
}

export function page(data) {
    return request({
        url: '/api/user/page',
        //post请求
        method: 'post',
        data
    })
}