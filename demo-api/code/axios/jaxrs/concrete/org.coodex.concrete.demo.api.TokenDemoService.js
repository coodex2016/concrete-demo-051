/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const TokenDemoService = {
    /**
     * /tokenValue
     * @param {*} value 
     * @returns Promise 
     */
    'setTokenValue': function (value) {
        return execute(module, `/OrgCoodexConcreteDemoApiTokenDemoService/tokenValue`, 'json', 'PUT', { value: value });
    }, 
    /**
     * /tokenValue
     * @returns Promise 
     */
    'getTokenValue': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTokenDemoService/tokenValue`, 'text', 'GET');
    }
}

export default TokenDemoService


