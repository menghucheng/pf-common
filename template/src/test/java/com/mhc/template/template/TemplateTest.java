/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：8:57 PM 2019/3/16
 */
package com.mhc.template.template;

import com.mhc.template.ProcessTemplateHolder;
import com.mhc.template.enums.TestEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：8:57 PM 2019/3/16
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath*:mhc-test-template.xml",
        "classpath*:com.mhc.template.common-template.xml"
})
public class TemplateTest {


    @Test
    public void test(){
        ProcessTemplateHolder.process(TestEnum.mhcSay,null);
    }
}
