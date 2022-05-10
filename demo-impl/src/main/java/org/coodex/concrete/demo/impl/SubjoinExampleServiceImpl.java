package org.coodex.concrete.demo.impl;

import org.coodex.concrete.common.Subjoin;
import org.coodex.concrete.common.WarningData;
import org.coodex.concrete.demo.api.SubjoinExampleService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashSet;
import java.util.Set;

import static org.coodex.concrete.demo.api.DemoErrorCodes.TOO_HARD;

@Named
public class SubjoinExampleServiceImpl implements SubjoinExampleService {

    // 用来存放访客信息
    private static final Set<String> VISITORS = new HashSet<>();

    @Inject // concrete-core-spring在spring framework中可以自动注入
    private Subjoin subjoin;

    @Override
    public String sayHello(String name) {
        // 使用双重校验锁确保每个访客最多产生一次新访客消息
        if (!VISITORS.contains(name)) {
            synchronized (VISITORS) {
                if (!VISITORS.contains(name)) {
                    VISITORS.add(name);
                    // 告知客户端，这是个新用户
                    subjoin.add("new-user", name);
                }
            }
        }
        return String.format("Hello, %s", name);
    }

    @Override
    public Integer add(Integer x1, Integer x2) {
        if (x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9) {
            subjoin.putWarning(new WarningData(TOO_HARD, x1, x2));
        }
        return x1 + x2;
    }
}