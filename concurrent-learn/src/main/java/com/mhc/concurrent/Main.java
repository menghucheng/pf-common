/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:34 PM 2019/3/27
 */
package com.mhc.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:34 PM 2019/3/27
 *
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        list.forEach((x)-> System.out.println(x+""));


    }
}
