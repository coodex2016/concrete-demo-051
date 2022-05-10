package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.util.Parameter;

@ConcreteService
public interface TokenDemoService {
    /**
     * @param value 往token里设置一个值
     */
    void setTokenValue(@Parameter("value") String value);

    /**
     * @return 获取token中的值
     */
    String getTokenValue();
}
