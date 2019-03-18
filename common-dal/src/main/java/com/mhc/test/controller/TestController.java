/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：10:15 PM 2019/2/14
 */
package com.mhc.test.controller;

import com.mhc.test.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：10:15 PM 2019/2/14
 *
 */
@Controller
public class TestController {

    @RequestMapping(value = "/show/{pageSize},{pageNum}")
    @ResponseBody
    public List<Product> show(@PathVariable int pageSize, @PathVariable int pageNum){
        return null;

    }
}
