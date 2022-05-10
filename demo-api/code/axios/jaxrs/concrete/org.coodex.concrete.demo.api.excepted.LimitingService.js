/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const LimitingService = {
    /**
     * /demoMaximumConcurrency
     * @returns Promise 
     */
    'demoMaximumConcurrency': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiExceptedLimitingService/demoMaximumConcurrency`, 'json', 'GET');
    }, 
    /**
     * /demoTokenBucket
     * @returns Promise 
     */
    'demoTokenBucket': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiExceptedLimitingService/demoTokenBucket`, 'json', 'GET');
    }
}

export default LimitingService


