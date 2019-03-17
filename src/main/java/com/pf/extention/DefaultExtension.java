/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：10:33 AM 2019/1/11
 */
package com.pf.extention;

import org.springframework.context.ApplicationContext;

import java.io.ObjectOutputStream;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：10:33 AM 2019/1/11
 *
 */
public class DefaultExtension implements Extensible {

    protected Class<?> descriptClass;

    protected ApplicationContext applicationContext;

    public void registerExtension(Extension extension) throws Exception {
        Object[] contributions = extension.getContributions();
        if(null != contributions){
            for (Object contribution : contributions) {
                registerContribution(contribution,extension.getExtensionPoint());
            }
        }
    }

    public void unRegisterExtension(Extension extension) throws Exception {
        Object[] contributions = extension.getContributions();
        if(null != contributions){
            for (Object contribution : contributions) {
                unRegisterContribution(contribution,extension.getExtensionPoint());
            }
        }
    }


    /**
     * need to implement
     * @param contribution
     * @param extentionPoints
     */
    public void registerContribution(Object contribution,String extentionPoints){

    }

    /**
     * need to implement
     * @param contribution
     * @param extentionPoints
     */
    public void unRegisterContribution(Object contribution,String extentionPoints){

    }



    public Class<?> getDescriptClass() {
        return descriptClass;
    }

    public void setDescriptClass(Class<?> descriptClass) {
        this.descriptClass = descriptClass;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
