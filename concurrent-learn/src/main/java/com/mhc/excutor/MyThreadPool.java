/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:35 PM 2019/3/27
 */
package com.mhc.excutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:35 PM 2019/3/27
 *
 */
public class MyThreadPool {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MyThreadPool.class);

    private int coreSize;

    private int maxSize;

    private long keepAliveTime;

    private TimeUnit timeUnit;

    private BlockingQueue<Runnable>  workQueue;


    private static ThreadPoolExecutor threadPoolExecutor = null;

    private ThreadFactory threadFactory;


    /**
     * 1.创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     * @param size
     * @return
     */
    public static ExecutorService newFixedThreadPool(int size){
        return new ThreadPoolExecutor(size,size,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
    }

    /**
     * 2.(JDK8新增)会根据所需的并发数来动态创建和关闭线程。能够合理的使用CPU进行对任务进行并发操作，所以适合使用在很耗时的任务。
     * @return
     */
    public static ExecutorService newWorkStealingPool(int parallelism){
        return new ForkJoinPool(parallelism, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    }

    /**
     * 创建一个可缓存的线程池，可灵活地回收空闲线程，若无空闲线程，则创建新的线程
     * @return
     */
    public static ExecutorService newCachedThredPool(){
        return new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
    }

    /**
     *  创建单个线程的线程池
     * @return
     */
    public static ExecutorService newSingleThreadExecutor(){
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    /**
     * 创建定长、定时、周期执行的线程池
     * @param coreSize
     * @return
     */
    public static ScheduledExecutorService newScheduledThreadPool(int coreSize){
        return new ScheduledThreadPoolExecutor(coreSize);
    }








}
