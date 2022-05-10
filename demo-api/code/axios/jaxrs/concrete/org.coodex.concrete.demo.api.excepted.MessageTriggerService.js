/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const MessageTriggerService = {
    /**
     * /trigger
     * @param {*} msg 
     * @returns Promise 
     */
    'trigger': function (msg) {
        return execute(module, `/OrgCoodexConcreteDemoApiExceptedMessageTriggerService/trigger`, 'json', 'POST', { msg: msg });
    }
}

export default MessageTriggerService


