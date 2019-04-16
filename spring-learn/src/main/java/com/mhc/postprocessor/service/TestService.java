/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:41 PM 2019/3/26
 */
package com.mhc.postprocessor.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mhc.postprocessor.dal.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:41 PM 2019/3/26
 *
 */
@org.springframework.stereotype.Service
public class TestService {

    /**
     * 不加@Autowired则可以使用postProcessor实现注入，必须要有set方法
     */
//    @Autowired
    private TestDao testDao;

    public void setTestDao(TestDao testDao) {
        System.out.println("inject testDao ");
        this.testDao = testDao;
    }

    public TestDao getTestDao() {
        return testDao;
    }
}
