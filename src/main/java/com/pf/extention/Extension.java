package com.pf.extention;

/**
 * @author ：tigermeng.
 * @desc ：
 * @date ：10:37 AM 2019/1/11
 */
public interface Extension {

    String getExtensionPoint();

    String getId();

    Object[] getContributions();
}
