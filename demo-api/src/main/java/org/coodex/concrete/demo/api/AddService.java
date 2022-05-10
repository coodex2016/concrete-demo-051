package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.util.Parameter;

@ConcreteService("Calculator")//为服务模块指定服务名
public interface AddService {
    // 为参数指定名称
    int add(@Parameter("x1") int x1, @Parameter("x2") int x2);
}
