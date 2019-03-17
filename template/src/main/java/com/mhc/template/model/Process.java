/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：5:57 PM 2019/3/16
 */
package com.mhc.template.model;

import java.io.Serializable;
import java.util.List;

/**
 * 执行链
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：5:57 PM 2019/3/16
 *
 */
public class Process implements Serializable {

    private static final long serialVersionUID = -2250305381133564876L;

    /**
     * 执行链s
     */
    private List<ProcessAction> actions;

    /**
     * desc
     */
    private String desc;

    public List<ProcessAction> getActions() {
        return actions;
    }

    public void setActions(List<ProcessAction> actions) {
        this.actions = actions;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
