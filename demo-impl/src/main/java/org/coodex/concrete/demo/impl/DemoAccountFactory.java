package org.coodex.concrete.demo.impl.account;

import org.coodex.concrete.common.Account;
import org.coodex.concrete.common.AccountFactory;
import org.coodex.concrete.common.NamedAccount;

import javax.inject.Named;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Named
public class DemoAccountFactory implements AccountFactory<String> {

    private static final Map<String, DemoAccount> accounts = new HashMap<String, DemoAccount>() {{
        put("A", new DemoAccount("A", "大侠A", "文史类"));
        put("B", new DemoAccount("B", "大侠B", "理工类"));
        put("C", new DemoAccount("C", "特权大佬", "*"));
    }};

    public static DemoAccount getAccount(String id){
        return accounts.get(id);
    }

    @Override
    public Account<String> getAccountByID(String s) {
        return getAccount(s);
    }

    public static class DemoAccount implements NamedAccount<String> {
        private final String id;
        private final String name;
        private final Set<String> roles = new HashSet<>();

        public DemoAccount(String id, String name, String domain) {
            this.id = id;
            this.name = name;
            roles.add(domain + ".图书管理员");
        }


        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public Set<String> getRoles() {
            return roles;
        }

        @Override
        public boolean isValid() {
            return true;
        }
    }
}