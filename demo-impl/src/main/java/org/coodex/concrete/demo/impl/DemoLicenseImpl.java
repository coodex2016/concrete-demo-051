package org.coodex.concrete.demo.impl;

import org.coodex.concrete.core.License;
import org.coodex.util.Singleton;

import javax.inject.Named;
import java.util.Calendar;

@Named
public class DemoLicenseImpl implements License {

    // license到期日，通过改变到期日来演示效果
    private final Singleton<Calendar> calendarSingleton = Singleton.with(() -> {
        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, -1);//deathLine为当前时间时间之前一天，已过期
//        calendar.add(Calendar.DATE, 1);//deathLine为当前时间时间之后一天，达到警告
        calendar.add(Calendar.DATE, 10);// deathLine为当前时间时间之后10天
        return calendar;
    });

    @Override
    public String check() throws OverdueException {
        Calendar now = Calendar.getInstance();
        Calendar deathLine = calendarSingleton.get();
        if (now.after(deathLine)) {
            throw new OverdueException("许可已超期");
        }
        // 如果3天以后到期，发警告
        now.add(Calendar.DATE, 3);
        if (now.after(deathLine)) {
            return "即将到期";
        }
        // 正常
        return null;
    }
}