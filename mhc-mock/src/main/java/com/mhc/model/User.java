/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：10:47 PM 2019/4/1
 */
package com.mhc.model;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：10:47 PM 2019/4/1
 *
 */
public class User {
    private int age;
    private String userName;

    public User(String userName,int age){
        this.age = age;
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
