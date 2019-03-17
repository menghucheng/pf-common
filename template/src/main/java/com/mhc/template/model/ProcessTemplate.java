/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：7:47 PM 2019/3/16
 */
package com.mhc.template.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 执行模板
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：7:47 PM 2019/3/16
 *
 */
public class ProcessTemplate implements Serializable {

    private static final long serialVersionUID = -1807701357569247098L;

    /**
     *
     * 模板中各执行链集合
     */
    private Map<String,Process> processes;


    /**
     * 模板描述
     */
    private String desc;

    public Map<String, Process> getProcesses() {
        return processes;
    }

    public void setProcesses(Map<String, Process> processes) {
        this.processes = processes;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
