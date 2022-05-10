/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const AddWithIn10Service = {
    /**
     * /add
     * @param {*} x1 
     * @param {*} x2 
     * @returns Promise 
     */
    'add': function (x1, x2) {
        return execute(module, `/OrgCoodexConcreteDemoApiAddWithIn10Service/add`, 'json', 'POST', { x1: x1, x2: x2 });
    }
}

export default AddWithIn10Service


