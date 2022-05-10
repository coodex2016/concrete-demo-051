/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const CarService = {
    /**
     * 获取一辆车的信息 - 数据包括车牌号车牌颜色等
     * @param {*} id 车辆id
     * @returns Promise 
     */
    'getCarById': function (id) {
        return execute(module, `/Cars/${id}`, 'json', 'GET');
    }, 
    /**
     * /warningExample
     * @returns Promise 
     */
    'warningExample': function () {
        return execute(module, `/Cars/warningExample`, 'json', 'GET');
    }, 
    /**
     * 获取车牌号 - 根据一辆车的id获取它车牌号
     * @param {*} id 车辆id
     * @returns Promise 
     */
    'getCarNumberById': function (id) {
        return execute(module, `/Cars/${id}/PlateCode`, 'text', 'GET');
    }
}

export default CarService


