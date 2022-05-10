package org.coodex.concrete.demo.impl;

import org.coodex.concrete.demo.api.excepted.LimitingService;
import org.coodex.util.Common;

import javax.inject.Named;

@Named
public class LimitingServiceImpl implements LimitingService {
    @Override
    public void demoMaximumConcurrency() {
        Common.sleep(10000);// 拖延十秒形成并发量
    }

    @Override
    public void demoTokenBucket() {
        // doNothing
    }
}