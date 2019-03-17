/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：10:20 AM 2019/1/11
 */
package com.pf.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：10:20 AM 2019/1/11
 *
 */
public class DmwkNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("extension",new DmwkBeandefinitionParser());
    }
}
