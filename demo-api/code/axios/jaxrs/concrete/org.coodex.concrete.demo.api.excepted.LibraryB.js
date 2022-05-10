/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const LibraryB = {
    /**
     * 整理书架
     * @returns Promise 
     */
    'sort': function () {
        return execute(module, `/B/Books/sort`, 'json', 'GET');
    }, 
    /**
     * 销毁一本书
     * @param {*} name 
     * @returns Promise 
     */
    'delete': function (name) {
        return execute(module, `/B/Books/${name}`, 'json', 'DELETE');
    }
}

export default LibraryB


