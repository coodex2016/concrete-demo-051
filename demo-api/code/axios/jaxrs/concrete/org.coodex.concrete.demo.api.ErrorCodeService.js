/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const ErrorCodeService = {
    /**
     * 使用Template注解
     * @returns Promise 
     */
    'templateAnnotation': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiErrorCodeService/templateAnnotation`, 'json', 'GET');
    }, 
    /**
     * 无配置
     * @returns Promise 
     */
    'noneAnnotation': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiErrorCodeService/noneAnnotation`, 'json', 'GET');
    }, 
    /**
     * freeMarker模板
     * @param {*} arg0 
     * @returns Promise 
     */
    'freeMarker': function (arg0) {
        return execute(module, `/OrgCoodexConcreteDemoApiErrorCodeService/freeMarker`, 'json', 'POST', arg0);
    }
}

export default ErrorCodeService


