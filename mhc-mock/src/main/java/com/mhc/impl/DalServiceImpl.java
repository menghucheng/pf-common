/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：10:47 PM 2019/4/1
 */
package com.mhc.impl;

import com.mhc.DalService;
import com.mhc.model.User;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：10:47 PM 2019/4/1
 *
 */
public class DalServiceImpl implements DalService {

    public String say(User user) {
        System.out.println(user.getUserName());
        return user.getUserName();
    }
}
