/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：2:13 AM 2019/3/17
 */
package com.mhc.template.template;

import com.mhc.template.ProcessTemplateHolder;
import com.mhc.template.enums.TestEnum;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：2:13 AM 2019/3/17
 *
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:mhc-test-template.xml",
                "classpath*:com.mhc.template.common-template.xml"});
        ProcessTemplateHolder.process(TestEnum.mhcSay,null);
    }
}
