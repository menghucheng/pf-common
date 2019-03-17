/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：9:23 PM 2019/3/16
 */
package com.mhc.template.enums;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：9:23 PM 2019/3/16
 *
 */
public enum TestEnum implements BaseProcessEnum{
    mhcSay("mhcSay","hello");

    private String template;
    private String process;

    TestEnum(String template,String process){
        this.template = template;
        this.process = process;
    }

    public String getTemplate() {
        return this.template;
    }

    public String getProcess() {
        return this.process;
    }
}
