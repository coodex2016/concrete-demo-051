/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const DemoSignatureService = {
    /**
     * /doSomeThing
     * @param {*} a 
     * @param {*} kkk 
     * @param {*} pojo 
     * @returns Promise 
     */
    'doSomeThing': function (a, kkk, pojo) {
        return execute(module, `/OrgCoodexConcreteDemoApiExceptedDemoSignatureService/doSomeThing`, 'json', 'POST', { a: a, kkk: kkk, pojo: pojo });
    }
}

export default DemoSignatureService


