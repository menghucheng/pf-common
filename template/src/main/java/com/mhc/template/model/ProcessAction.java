/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：5:48 PM 2019/3/16
 */
package com.mhc.template.model;

import com.mhc.template.action.BaseAction;

import java.io.Serializable;

/**
 * processAction model
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：5:48 PM 2019/3/16
 *
 */
public class ProcessAction implements Serializable {

    private static final long serialVersionUID = 6739434781194694903L;

    /**
     * action
     */
    private BaseAction action;

    /**
     * desc
     */
    private String desc;

    public BaseAction getAction() {
        return action;
    }

    public void setAction(BaseAction action) {
        this.action = action;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
