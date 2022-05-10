/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const TimeLimitedService = {
    /**
     * /lunch
     * @returns Promise 
     */
    'lunch': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTimeLimitedService/lunch`, 'json', 'GET');
    }, 
    /**
     * /work
     * @returns Promise 
     */
    'work': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTimeLimitedService/work`, 'json', 'GET');
    }, 
    /**
     * /breakfast
     * @returns Promise 
     */
    'breakfast': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTimeLimitedService/breakfast`, 'json', 'GET');
    }, 
    /**
     * /dinner
     * @returns Promise 
     */
    'dinner': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTimeLimitedService/dinner`, 'json', 'GET');
    }
}

export default TimeLimitedService


