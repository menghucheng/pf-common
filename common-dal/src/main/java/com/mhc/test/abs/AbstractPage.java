/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:10 PM 2019/2/15
 */
package com.mhc.test.abs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:10 PM 2019/2/15
 *
 */

@Getter
@Setter
public class AbstractPage<T> {

    private int pageNum;

    private int pageSize;

    private List<T> list;
}
