/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：5:57 PM 2019/1/22
 */
package com.pf.test;

import org.apache.dubbo.bootstrap.DubboBootstrap;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @desc       ：imitate
 * @author     ：tigermeng.
 * @date       ：5:57 PM 2019/1/22
 *
 */
public class BaseTester {

    /**
     * before all tests
     */
    @BeforeClass
    public static void testBefore(){
        //init Provider
        initialProvider();
        //init Consumer
        initialConsumer();
    }

    public void methodBefore(){
//        initialDB();

//        initialBeanReference();

//        intialService();
    }

    public void methodAfter(){

    }

    @AfterClass
    public static void testAfter(){

    }


    private static void initialProvider() {
    }

    private static void initialConsumer() {

    }
}
