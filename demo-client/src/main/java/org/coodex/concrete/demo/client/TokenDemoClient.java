package org.coodex.concrete.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.Client;
import org.coodex.concrete.demo.api.TokenDemoService;

@Slf4j
public class TokenDemoClient {
    public static void main(String[] args) {
        TokenDemoService tokenDemoService = Client.getInstance(TokenDemoService.class, "demoModule");
        tokenDemoService.getTokenValue();
        tokenDemoService.setTokenValue("你好");
        log.info("getTokenValue: {}", tokenDemoService.getTokenValue());
    }
}
