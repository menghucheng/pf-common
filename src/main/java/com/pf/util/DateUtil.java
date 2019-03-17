/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：6:50 PM 2019/1/22
 */
package com.pf.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：6:50 PM 2019/1/22
 *
 */
public class DateUtil {

    private static final String SHORT_DATE = "yyyy-MM-dd HH:mm:ss";

    public static String formatNow() {
        return new SimpleDateFormat(SHORT_DATE).format(getNow());
    }

    public static Date getNow(){
        return new Date();
    }
}
