/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：16:53 2019-04-12
 */
package com.mhc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：16:53 2019-04-12
 *
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    /**
     *     使用@Async支持，不仅可以支持通用调用，也支持异步调用，非常灵活
     */
    @Async
    @Override
    public void onApplicationEvent(DemoEvent event) {
        System.out.println("注册成功，发送确认邮件:" + event.getMsg() + "===" + event.getMsg());
    }
}
