/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:45 PM 2019/3/26
 */
package com.mhc.postprocessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:45 PM 2019/3/26
 *
 */
@Component
public class MhcBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition gb = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("testService");
        //Autowired default 2 -- byType
        gb.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);
    }
}
