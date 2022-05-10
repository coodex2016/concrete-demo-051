package org.coodex.concrete.demo.impl;

import org.coodex.concrete.common.Account;
import org.coodex.concrete.common.NamedAccount;
import org.coodex.concrete.common.Token;
import org.coodex.concrete.demo.api.excepted.AbstractLibrary;
import org.coodex.concrete.demo.pojo.Book;
import org.coodex.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;

public abstract class AbstractLibraryImpl<B extends Book> implements AbstractLibrary<B> {
    private static final String[] attr = new String[]{
            "大胆的", "愤怒的", "没脑子的"
    };

    private static final String[] names = new String[]{
            "小明", "小红", "小强"
    };
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Inject
    private Token token; // 令牌里存放着用户信息

    protected abstract Map<String, Book> getBooks();

    protected abstract String getType();

    private String getAccountName() {
        Account<?> account = token.currentAccount();
        if (account instanceof NamedAccount) {// NamedAccount是
            return ((NamedAccount<?>) account).getName();
        }
        return Common.random(names) + "(化名)";
    }

    private String getAttr() {
        return Common.random(attr);
    }

    @Override
    public void delete(String name) {
        if (getBooks().containsKey(name)) {
            Book book = getBooks().remove(name);
            log.info("{} {} 把 {} 图书[{}]销毁了。", getAttr(), getAccountName(), getType(), book);
        } else {
            log.info("nothing happened.");
        }
    }

    @Override
    public void sort() {
        getBooks().clear();
        log.info("哦嚯，{} {} 把 {} 图书全部销毁了。", getAttr(), getAccountName(), getType());
    }
}