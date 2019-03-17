/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：3:49 PM 2019/3/16
 */
package com.mhc.template.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * mhc.teplate.mhc.template.spring beans getter
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：3:49 PM 2019/3/16
 *
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    /**
     * 注入spring上下文
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }


    /**
     * 根据的bean id获取spring管理的bean
     * @param name
     * @param <T>
     * @return
     * @throws BeansException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException{
        return (T)applicationContext.getBean(name);
    }

    /**
     * check contains bean
     * @param name
     * @return
     */
    public static boolean containsBean(String name){
        return applicationContext.containsBean(name);
    }

    /**
     *
     * check is the bean of appointed name singleton
     * @param name
     * @return
     */
    public static boolean isSingleton(String name){
        return applicationContext.isSingleton(name);
    }


    /**
     *  get Bean By requiredType
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBeanByType(Class<T> requiredType){
        return applicationContext.getBean(requiredType);
    }
}
