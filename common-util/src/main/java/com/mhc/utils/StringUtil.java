/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:24 PM 2019/3/18
 */
package com.mhc.utils;

import org.springframework.lang.Nullable;

/**
 *  字符串工具类
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:24 PM 2019/3/18
 *
 */
public class StringUtil {

    /**
     * is Empty
     * @param str
     * @return
     */
    public static boolean isEmpty(@Nullable String str) {
        return str == null || "".equals(str);
    }

    /**
     * is Blank
     * @param source
     * @return
     */
    public static boolean isBlank(@Nullable String source){
        if (null == source || source.length() ==0){
            return true;
        }
        char[] chars = source.toCharArray();
        for (char ch: chars) {
            if (!Character.isWhitespace(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.isBlank("  a  "));
    }
}
