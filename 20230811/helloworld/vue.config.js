const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    //解决跨域，使用前端代理
    // 原始请求http://localhost:8080/api/user/login ===> 转换后请求http://localhost:8081/user/login
    proxy: {
      // 请求以api开始的url 进行代理请求
      '/api': {
        target: 'http://localhost:8081',//代理请求 base url
        changeOrigin: true,//允许跨域
        // 路径重写
        pathRewrite: {
          '^/api': ''// /api重写成 空字符串
        }
      },
      '/image': {
        target: 'http://localhost:8081',//代理请求 base url
        changeOrigin: true,//允许跨域
        // 路径重写
        // pathRewrite: {
        //   '^/image': '' //// /image重写成 空字符串
        // }
      }
    }
  }
})
