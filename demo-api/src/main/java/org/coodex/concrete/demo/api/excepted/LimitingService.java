package org.coodex.concrete.demo.api.excepted;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.limiting.MaximumConcurrency;
import org.coodex.concrete.api.limiting.TokenBucket;

@ConcreteService
public interface LimitingService {

    @MaximumConcurrency(strategy = "demo")
    void demoMaximumConcurrency();

    @TokenBucket(
            bucket = "demo", // 使用哪个桶里的令牌
            tokenUsed = 10 // 本服务一次需要10个令牌
    )
    void demoTokenBucket();
}