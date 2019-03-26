/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:44 PM 2019/3/26
 */

import com.mhc.postprocessor.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:44 PM 2019/3/26
 *
 */

@Configuration
@ComponentScan("com.mhc")
public class SpringLearningApplicationConfig {

    /**
     *  Bean 注解也可以实现Bean交由spring管理
     *
     */
//    @Bean
//    public TestService testService(){
//        return new TestService();
//    }

}
