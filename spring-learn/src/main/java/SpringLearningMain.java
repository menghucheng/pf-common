/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:53 PM 2019/3/26
 */

import com.mhc.postprocessor.dal.TestDao;
import com.mhc.postprocessor.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:53 PM 2019/3/26
 *
 */
public class SpringLearningMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringLearningApplicationConfig.class);
        ctx.refresh();
        TestService testService = ctx.getBean("testService", TestService.class);
        TestDao testDao = testService.getTestDao();
        testDao.insert();
    }
}
