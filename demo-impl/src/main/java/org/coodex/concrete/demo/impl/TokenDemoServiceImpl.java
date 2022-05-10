package org.coodex.concrete.demo.impl;

import org.coodex.concrete.common.Token;
import org.coodex.concrete.demo.api.TokenDemoService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TokenDemoServiceImpl implements TokenDemoService {
    private final static String TOKEN_KEY = "DEMO_KEY";

    @Inject // <-- 注入token
    private Token token;

    @Override
    public void setTokenValue(String value) {
        token.setAttribute(TOKEN_KEY, value);
    }

    @Override
    public String getTokenValue() {
        return token.getAttribute(TOKEN_KEY, String.class);
    }
}
