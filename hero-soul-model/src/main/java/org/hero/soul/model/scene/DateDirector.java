package org.hero.soul.model.scene;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间管理者
 *
 * Created by devil on 2017/5/3.
 */
public class DateDirector {
    public static final int LEAP_YEAR = 366;
    public static final int NOLEAP_YEAR = 365;
    public static Date NOW = new Date();
    private static  Calendar calendar = Calendar.getInstance();

    /**
     * 今年的天数
     */
    public static int yearDaySize(){
        return NOLEAP_YEAR;
    }

    /**
     * 根据类型，返回时间
     */
    public static int getTypeTime(int type){
        calendar.setTime(NOW);
        return calendar.get(type);
    }

    /**
     * 更新天数
     */
    public static void updateTime(){
        calendar.setTime(NOW);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        NOW = calendar.getTime();
    }


}
