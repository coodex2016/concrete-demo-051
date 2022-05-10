/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const DemoLoginService = {
    /**
     * /login
     * @param {*} id 
     * @returns Promise 
     */
    'login': function (id) {
        return execute(module, `/OrgCoodexConcreteDemoApiExceptedDemoLoginService/login`, 'json', 'POST', { id: id });
    }
}

export default DemoLoginService


