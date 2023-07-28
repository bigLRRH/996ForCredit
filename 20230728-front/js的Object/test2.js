// import关键字导入js模块
// 导入的test.js文件模块中导出的对象或者函数，要保持名称一致
import { name, email } from "./test"// 导入的时候 如果是js文件后缀的.js可以不写
import { mm } from "./test1";
// 直接使用
console.log(email);
// 调用函数mm
mm();