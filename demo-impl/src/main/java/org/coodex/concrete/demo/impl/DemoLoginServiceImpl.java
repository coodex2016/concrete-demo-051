package org.coodex.concrete.demo.impl;

import org.coodex.concrete.common.IF;
import org.coodex.concrete.common.Token;
import org.coodex.concrete.demo.api.excepted.DemoLoginService;
import org.coodex.concrete.demo.impl.account.DemoAccountFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DemoLoginServiceImpl implements DemoLoginService {

    @Inject
    private Token token;

    @Override
    public void login(String id) {
        token.setAccount(
                IF.isNull(
                        DemoAccountFactory.getAccount(id),
                        // 这个用法不规范，应该先定义ErrorCode，然后编写异常资源信息在此使用ErrorCode
                        "none this account: " + id
                )
        );
        // 该用户是可信的，与@safely注解有关，详见concrete-api说明
        token.setAccountCredible(true);
    }
}