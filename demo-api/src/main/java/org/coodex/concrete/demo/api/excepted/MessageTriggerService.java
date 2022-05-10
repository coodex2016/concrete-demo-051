package org.coodex.concrete.demo.api.excepted;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.util.Parameter;

@ConcreteService
public interface MessageTriggerService {

    // 触发一条消息
    void trigger(@Parameter("msg") String msg);
}