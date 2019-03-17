package com.pf.extention;

/**
 * @author ：tigermeng.
 * @desc ：
 * @date ：10:34 AM 2019/1/11
 */
public interface Extensible {

  void registerExtension(Extension extension) throws Exception;

  void unRegisterExtension(Extension extension) throws Exception;
}
