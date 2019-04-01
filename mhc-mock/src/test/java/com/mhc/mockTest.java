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
    }

    @Test
    public void tesMock(){
        dalService = new DalServiceImpl();
        dalService.say(user);
        when(dalService.say(user)).thenReturn("Hello mock");
//        verify(dalService).say(user);
    }



}
