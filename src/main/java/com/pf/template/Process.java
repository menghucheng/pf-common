/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：2:13 PM 2019/1/11
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
 * @date       ：2:13 PM 2019/1/11
 *
 */
public class Process {

    private List<Action> actionList = new ArrayList<Action>();

    private Map<String, Action> actionMap = new HashMap<String, Action>();

    private String name;

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public Map<String, Action> getActionMap() {
        return actionMap;
    }

    public void setActionMap(Map<String, Action> actionMap) {
        this.actionMap = actionMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
