/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：16:44 2019-04-12
 */
package com.mhc.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：16:44 2019-04-12
 *
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;

    private String emailAddr;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEvent(Object source,String msg,String emailAddr) {
        super(source);
        this.msg = msg;
        this.emailAddr = emailAddr;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }
}
