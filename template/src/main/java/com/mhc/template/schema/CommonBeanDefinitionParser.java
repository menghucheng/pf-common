/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：4:27 PM 2019/3/16
 */
package com.mhc.template.schema;

import com.mhc.template.constants.TemplateConstants;
import com.mhc.template.model.Process;
import com.mhc.template.model.ProcessAction;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.List;

/**
 * parser xml BeanDefinition
 *
 * @author ：tigermeng.
 * @desc ：
 * @date ：4:27 PM 2019/3/16
 */
public class CommonBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {

    private final Class<?> beanClass;

    private final boolean requiered;


    public CommonBeanDefinitionParser(Class<?> beanClass, boolean requiered) {
        this.beanClass = beanClass;
        this.requiered = requiered;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        builder.addPropertyValue(TemplateConstants.ACTIONS, parseMapElement(element, parserContext, builder));
    }

    private static ManagedList<BeanDefinition> parseMapElement(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        //获取当前流程下各action节点
        List<Element> elements = DomUtils.getChildElementsByTagName(element, TemplateConstants.ACTION);

        //elements is not null
        ManagedList<BeanDefinition> managedList = new ManagedList<BeanDefinition>(elements.size());
        //merge is available(eg:between this object and parent)
        managedList.setMergeEnabled(true);
        managedList.setSource(parserContext.getReaderContext().extractSource(element));

        //解析各action结点
        for (Element ele : elements) {
            //创建BeanDefinition
            GenericBeanDefinition gb = new GenericBeanDefinition();
            gb.setLazyInit(false);
            gb.setBeanClass(ProcessAction.class);
            String desc = ele.getAttribute(TemplateConstants.DESC);
            String ref = ele.getAttribute(TemplateConstants.REF);
            MutablePropertyValues propertyValues = gb.getPropertyValues();
            propertyValues.add(TemplateConstants.DESC, desc);
            propertyValues.add(TemplateConstants.ACTION, new RuntimeBeanReference(ref));
            managedList.add(gb);
        }

        return managedList;
    }

    public Class<?> getBeanClass() {
        return Process.class;
    }
}
