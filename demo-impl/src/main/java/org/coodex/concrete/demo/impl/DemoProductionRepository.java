package org.coodex.concrete.demo.impl;

import org.coodex.concrete.common.Account;
import org.coodex.concrete.common.Production;
import org.coodex.concrete.common.ProductionRepository;
import org.coodex.concrete.demo.impl.account.DemoAccountFactory;
import org.coodex.util.Common;
import org.coodex.util.Profile;

import javax.inject.Named;
import java.text.ParseException;
import java.util.*;

@Named
public class DemoProductionRepository implements ProductionRepository {
    @Override
    public List<Production> getProductionsBy(Account account, String[] modules) {
        final DemoAccountFactory.DemoAccount demoAccount = (DemoAccountFactory.DemoAccount) account;
        return Collections.singletonList(new Production() {
            private final String name = "P_" + demoAccount.getId();
            private final Profile profile = Profile.get(name);
            private final Set<String> modules = new HashSet<>(Arrays.asList(profile.getStrList("modules")));

            @Override
            public Calendar getCalendar() {
                try {
                    return Common.strToCalendar(profile.getString("validate"), Common.DEFAULT_DATE_FORMAT);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public Integer getRemindDays() {
                return 7;
            }

            @Override
            public String getProductionName() {
                return name;
            }

            @Override
            public Set<String> getModules() {
                return modules;
            }
        });
    }

    @Override
    public boolean accept(Account param) {
        return param instanceof DemoAccountFactory.DemoAccount;
    }
}