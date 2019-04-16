/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：17:09 2019-04-12
 */
package com.mhc.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：17:09 2019-04-12
 *
 */
@Component
public class DemoEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;


    public void publish(String msg,String emailAddr){

        applicationEventPublisher.publishEvent(new DemoEvent(this,msg,emailAddr));

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
