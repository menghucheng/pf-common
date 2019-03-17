package com.mhc.template.action;

/**
 * 执行action抽象接口
 * @author ：tigermeng.
 * @param <CONTEXT>
 * @desc ：
 * @date ：4:08 PM 2019/3/16
 */
public interface BaseAction<CONTEXT> {

    /**
     * 执行方法
     * @param context
     */
    void process(CONTEXT context);
}
