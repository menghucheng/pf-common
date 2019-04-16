/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:25 PM 2019/3/18
 */
package com.mhc.utils;

import org.springframework.lang.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  日期工具类
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:25 PM 2019/3/18
 *
 */
public class DateUtil {

    private static final String SHORT_DATE = "yyyy-MM-dd HH:mm:ss";


    /**
     *
     * @return 当前时间
     */
    public static Date getNow(){
        return new Date();
    }

    /**
     *  get "yyyyMMdd" date String
     * @param date nullable
     * @return
     */
    public static String getShortDate(@Nullable Date date){
        if(date == null){
            date = new Date();
        }

        SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE);
        return sdf.format(date);
    }


    public static void main(String[] args) {
        System.out.println(getShortDate(null));
    }
}
