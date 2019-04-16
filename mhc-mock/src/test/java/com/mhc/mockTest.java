/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：10:46 PM 2019/4/1
 */
package com.mhc;

import com.mhc.impl.DalServiceImpl;
import com.mhc.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：10:46 PM 2019/4/1
 *
 */
public class mockTest {

    private User user;


    @Mock
    private DalService dalService;



    @Before
    public void setUp(){
        user = new User("mhc",18);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void tesMock(){
        dalService = spy(new DalServiceImpl());
//        dalService.say(user);
        when(dalService.say(user)).thenReturn("Hello mock");

        doReturn("aaaa").when(dalService).say(user);
        verify(dalService).say(user);
    }



}
