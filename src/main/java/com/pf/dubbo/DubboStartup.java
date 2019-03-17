/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：6:13 PM 2019/1/22
 */
package com.pf.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.utils.ConfigUtils;
import com.alibaba.dubbo.container.Container;
import com.pf.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：6:13 PM 2019/1/22
 *
 */
public class DubboStartup {

    private static final Logger logger = LoggerFactory.getLogger(DubboStartup.class);

    public static final String CONTAINER_KEY = "dubbo.container";

    public static final String SHUTDOWN_HOOK_KEY = "dubbo.shutdown.hook";

    private static final ExtensionLoader<Container> loader = ExtensionLoader.getExtensionLoader(Container.class);

    private static volatile boolean RUNNING = true;

    private static volatile boolean STARTED = false;

    private static final List<Container> containers = new ArrayList<Container>();

    public static void main(String[] args) {
        try{
            System.setProperty("java.net.preferIPv4Stack","true");

            dealArgs(args);

            startContainers();

        }catch (RuntimeException e){
            logger.error(e.getMessage(),e);
            //0 正常退出  非0表示非正常退出，System.exit()直接回到最上层，相对的 return是指返回上一层
            System.exit(1);
        }

        synchronized (DubboStartup.class){
            while (RUNNING){
                try{
                    DubboStartup.class.wait();
                }catch (Throwable e){
                }
            }
        }

    }


    /**
     * dealArgs
     * @param args
     */
    private static void dealArgs(String[] args) {
        if(args == null || args.length ==0){
            String extensionNames = ConfigUtils.getProperty(CONTAINER_KEY, loader.getDefaultExtensionName());
            args = Constants.COMMA_SPLIT_PATTERN.split(extensionNames);
        }

        for (String arg : args) {
            containers.add(loader.getExtension(arg));
        }
        logger.info("Use container type("+ Arrays.toString(args) + ") to run dubbo service.");
    }

    /**
     * startContainers
     */
    private static void startContainers() {

        //to stop all if started
        if ("true".equals(System.getProperty(SHUTDOWN_HOOK_KEY))){
            Runtime.getRuntime().addShutdownHook(new Thread(){
                @Override
                public void run() {
                    for (Container container : containers) {
                        try{
                            container.stop();
                            logger.info("Dubbo "+container.getClass().getSimpleName()+" stopped!");
                        }catch (Throwable t){
                            logger.error(t.getMessage(),t);
                            synchronized (DubboStartup.class){
                                RUNNING = false;
                                STARTED = false;
                                //唤醒等待该DubboStartup.class对象的线程之一
                                DubboStartup.class.notify();
                            }
                        }
                    }
                }
            });
        }

        // to start
        for (Container container : containers) {
            container.start();
            logger.info("Dubbo "+container.getClass().getSimpleName()+" started!");
        }
        STARTED = true;

        System.out.println("[" + DateUtil.formatNow() + "]" + "Dubbo service server started!");
    }

    /**
     *
     * @return
     */
    public static boolean isSTARTED(){
        return STARTED;
    }
}
