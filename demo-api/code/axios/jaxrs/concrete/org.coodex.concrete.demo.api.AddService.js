/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const AddService = {
    /**
     * /add
     * @param {*} x1 
     * @param {*} x2 
     * @returns Promise 
     */
    'add': function (x1, x2) {
        return execute(module, `/Calculator/add`, 'json', 'POST', { x1: x1, x2: x2 });
    }
}

export default AddService


