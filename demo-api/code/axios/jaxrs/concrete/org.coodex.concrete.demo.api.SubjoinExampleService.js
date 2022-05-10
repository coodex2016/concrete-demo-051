/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const SubjoinExampleService = {
    /**
     * 由开发者手动设置warning data的示例 - 同之前的案例一样，不过把异常改为警告，当加数和被加数不是个位数时，向调用者发送一个太难了的警告
     * @param {*} x1 
     * @param {*} x2 
     * @returns Promise 
     */
    'add': function (x1, x2) {
        return execute(module, `/SubjoinExample/add`, 'json', 'POST', { x1: x1, x2: x2 });
    }, 
    /**
     * 向某人say hello - 当此人为第一次访问时，我们通过subjoin返回新用户的信息
     * @param {*} name 
     * @returns Promise 
     */
    'sayHello': function (name) {
        return execute(module, `/SubjoinExample/sayHello`, 'text', 'POST', { name: name });
    }
}

export default SubjoinExampleService


