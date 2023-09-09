import request from '@/utils/axios-req'

export interface LoginForm {
    username: string;
    password: string;
    // 记住密码
    // rememberMe: boolean;
    // 验证码相关
    code: string;
    uuid: string
}

//登录
export function loginReq(loginForm: LoginForm) {
    return request({
        url: '/login',
        data: loginForm,
        method: 'post',
        isNotTipErrorMsg: true
    })
}

//获取验证码
export function getCodeImg() {
    return request({
        url: '/login/captchaImage',
        headers: {
            isToken: false
        },
        method: 'get'
    })
}