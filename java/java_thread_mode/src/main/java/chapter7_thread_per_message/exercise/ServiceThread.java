package chapter7_thread_per_message.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: ServiceThread
 * @description: 事件放入线程处理
 * @author: lian.zh
 * @create: 2019-01-22 10:32
 */
public class ServiceThread {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void service() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Service.service();
            }
        });
    }
}
