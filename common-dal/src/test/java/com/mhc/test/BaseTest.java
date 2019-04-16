/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:56 PM 2019/3/18
 */
package com.mhc.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:56 PM 2019/3/18
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath*:/generator/*.xml",
})
@Slf4j
public class BaseTest {
//    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @Test
    public void testDal(){
        log.info("begin");
        System.out.println("=====");
        log.info("end");
    }
}
