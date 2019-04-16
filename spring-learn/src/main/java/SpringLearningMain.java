/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:53 PM 2019/3/26
 */

import com.mhc.event.DemoEventPublisher;
import com.mhc.event.DemoListener;
import com.mhc.postprocessor.dal.TestDao;
import com.mhc.postprocessor.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:53 PM 2019/3/26
 *
 */
public class SpringLearningMain {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringLearningApplicationConfig.class);
//        ctx.register(SpringLearningApplicationConfig.class);
//        ctx.refresh();
//        TestService testService = ctx.getBean("testService", TestService.class);
//        TestDao testDao = testService.getTestDao();
//        testDao.insert();

        DemoEventPublisher bean = ctx.getBean(DemoEventPublisher.class);
        DemoListener listener = ctx.getBean(DemoListener.class);

        System.out.println(listener);
        bean.publish("hello","163.com");
        bean.publish("hello","163.com");
        bean.publish("hello","163.com");


    }
}
