/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：4:18 PM 2019/3/16
 */
package com.mhc.template.model;

/**
 *  抽象Action
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：4:18 PM 2019/3/16
 *
 */
public class Action {

    /**
     * name
     */
    String name;

    /**
     * desc
     */
    String desc;

    /**
     * bean
     */
    Object bean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
