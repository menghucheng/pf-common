/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：4:26 PM 2019/3/16
 */
package com.mhc.template.schema;

import com.mhc.template.constants.TemplateConstants;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * namespace handler
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：4:26 PM 2019/3/16
 *
 */
public class CommonNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser(TemplateConstants.TEMPLATES,new TemplatesBeanParser());
    }
}
