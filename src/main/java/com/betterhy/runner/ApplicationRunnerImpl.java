package com.betterhy.runner;

import com.betterhy.utils.OaUtils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 启动时执行
 *
 * @author Source
 * @date 2020-09-08 14:17
 **/
//使用时放开下面一行
//@Component
//@Order(1)
public class ApplicationRunnerImpl implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunnerImpl.class);
    private final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("RedisRunner-%d").build();
    private final ExecutorService queueThreadPool = new ThreadPoolExecutor(10, 20, 200L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);

    @Override
    public void run(ApplicationArguments args) {
        logger.info("===========================");
        try {
            //do something
            TicketRunnable ticketRunnable = new TicketRunnable();
            for (int i = 0; i < 5; i++) {
                queueThreadPool.execute(ticketRunnable);
            }
        } catch (Exception e) {
            logger.error("自启动程序发生异常");
        }
    }

    /**
     * 实现Runnable接口并重写run方法
     */
    static class TicketRunnable implements Runnable{
        int ticket=100;
        final Object obj = new Object();
        @Override
        public void run() {
            while (true){
                synchronized(obj) {
                    //卖票
                    if (ticket>0){
                        try {
                            logger.info(Thread.currentThread().getName() + "剩余票量:" + (--ticket));
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            logger.error(OaUtils.getStackTraceInfo(e));
                        }
                    }else {
                        break;
                    }
                }
            }
        }
    }
}
