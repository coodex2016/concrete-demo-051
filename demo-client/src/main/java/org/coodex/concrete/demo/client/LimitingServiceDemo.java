package org.coodex.concrete.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.Client;
import org.coodex.concrete.ClientException;
import org.coodex.concrete.demo.api.excepted.LimitingService;
import org.coodex.concurrent.ExecutorsHelper;
import org.coodex.util.Common;

import java.util.concurrent.ExecutorService;

@Slf4j
public class LimitingServiceDemo {

    private static final ExecutorService EXECUTOR_SERVICE =
            ExecutorsHelper.newFixedThreadPool(30, "demo");

    public static void main(String[] args) {
        LimitingService limitingService = Client.getInstance(LimitingService.class, "demoModule");
        // 连着请求 demoMaximumConcurrency
        for (int i = 1; i <= 20; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.execute(() -> {

                try {
                    limitingService.demoMaximumConcurrency();
                } catch (ClientException e) {
                    log.info("{}, demoMaximumConcurrency {}", finalI, e.getLocalizedMessage());
                }
            });
            Common.sleep(1000);
        }


        EXECUTOR_SERVICE.execute(() -> {
            for (int i = 1; i < 30; i++) {
                try {
                    limitingService.demoTokenBucket();
                } catch (ClientException e) {
                    log.info("{}, demoTokenBucket {}", i, e.getLocalizedMessage());
                }
                if (i % 5 == 0) { // 每5个任务一组，每组之间休息800毫秒
                    Common.sleep(800);
                }
            }
        });
    }

}