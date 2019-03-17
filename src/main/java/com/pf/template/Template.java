/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：2:10 PM 2019/1/11
 */
package com.pf.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：2:10 PM 2019/1/11
 *
 */
public class Template {

    private Map<String, Process> processMap = new HashMap<String, Process>();

    private List<Process> processList  = new ArrayList<Process>();

    private String name;

    public Template(String name,List<Process> processList){
        this.name = name;
        this.processList = processList;

        for (Process process : processList) {
            this.processMap.put(process.getName(),process);
        }
    }

    public Map<String, Process> getProcessMap() {
        return processMap;
    }

    public void setProcessMap(Map<String, Process> processMap) {
        this.processMap = processMap;
    }

    public List<Process> getProcessList() {
        return processList;
    }

    public void setProcessList(List<Process> processList) {
        this.processList = processList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
