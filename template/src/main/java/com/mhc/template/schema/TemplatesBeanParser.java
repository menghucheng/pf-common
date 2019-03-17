/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：6:10 PM 2019/3/16
 */
package com.mhc.template.schema;

import com.mhc.template.model.Process;
import com.mhc.template.model.ProcessAction;
import com.mhc.template.model.ProcessTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.List;

/**
 * 执行链模板解析器
 *
 * @author ：tigermeng.
 * @desc ：
 * @date ：6:10 PM 2019/3/16
 */
public class TemplatesBeanParser implements BeanDefinitionParser {


    private static final Logger logger = LoggerFactory.getLogger(TemplatesBeanParser.class);

    /**
     * 实现解析过程
     *
     * @param element
     * @param parserContext
     * @return
     */
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();

        try {
            rootBeanDefinition.setBeanClass(ProcessTemplate.class);
            rootBeanDefinition.setLazyInit(false);

            String id = element.getAttribute("id");
            String desc = element.getAttribute("desc");

            MutablePropertyValues propertyValues = rootBeanDefinition.getPropertyValues();
            propertyValues.add("desc", desc);
            ManagedMap<String, BeanDefinition> managedMap = parseProcesses(element, parserContext);
            propertyValues.add("processes", managedMap);
            parserContext.getRegistry().registerBeanDefinition(id,rootBeanDefinition);
        } catch (Exception e) {
            logger.error("template parse error ", e);
            throw new RuntimeException("template parse error", e);
        }

        return rootBeanDefinition;
    }

    private ManagedMap<String,BeanDefinition> parseProcesses(Element element,ParserContext parserContext){
        //获取所有process集合
        List<Element> elementList = DomUtils.getChildElementsByTagName(element,"processes");

        ManagedMap<String, BeanDefinition> managedMap = new ManagedMap<String, BeanDefinition>(elementList.size());
        //enable merge
        managedMap.setMergeEnabled(true);
        managedMap.setSource(parserContext.getReaderContext().extractSource(element));
        for (Element ele : elementList) {
            GenericBeanDefinition gb = new GenericBeanDefinition();
            gb.setLazyInit(false);
            gb.setBeanClass(Process.class);
            String id = ele.getAttribute("id");
            String desc = ele.getAttribute("desc");

            MutablePropertyValues propertyValues = gb.getPropertyValues();
            propertyValues.add("actions", parseAction(ele, parserContext));
            propertyValues.add("desc", desc);

            if(managedMap.containsKey(id)){
                throw new RuntimeException("process:" + id + "non-unique in the mhc.teplate.mhc.template.spring");
            }
            managedMap.put(id, gb);
        }
        return managedMap;
    }

    private ManagedList<BeanDefinition> parseAction(Element element, ParserContext parserContext) {
        List<Element> elementList = DomUtils.getChildElementsByTagName(element, "action");
        //获取当前处理流程下的所有action结点
        ManagedList<BeanDefinition> managedList = new ManagedList<BeanDefinition>(elementList.size());
        managedList.setMergeEnabled(true);
        managedList.setSource(parserContext.getReaderContext().extractSource(element));
        for (Element ele : elementList) {
            GenericBeanDefinition gb = new GenericBeanDefinition();
            gb.setBeanClass(ProcessAction.class);
            gb.setLazyInit(false);
            String desc = ele.getAttribute("desc");
            String ref = ele.getAttribute("ref");
            MutablePropertyValues propertyValues = gb.getPropertyValues();
            propertyValues.add("desc", desc);
            propertyValues.add("action", new RuntimeBeanReference(ref));
            managedList.add(gb);
        }
        return managedList;
    }
}
