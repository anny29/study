package chapter10_two_phase_termination.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: Service
 * @description: 练习 10-5
 * @author: lian.zh
 * @create: 2019-03-06 10:26
 */
@Slf4j
public class Service {

    private volatile boolean isCanceled = false;
    private volatile boolean isExecuting = false;

    public void service() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (isExecuting)
                    return;

                isExecuting = true;
                isCanceled = false;
                System.out.println();
                System.out.print("service");
                try {
                    for (int i = 1; i <= 99 && !isCanceled; i++) {
                        System.out.print(".");
//                log.info("{}", i);
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } catch (InterruptedException e) {
                    log.error("睡眠中断", e);
                } finally {
                    System.out.print("done.");
                    isExecuting = false;
                }
            }
        }).start();
    }

    public void cancel() {
        if (isCanceled || !isExecuting)
            return;
        new Thread(new Runnable() {
            @Override
            public void run() {
                isCanceled = true;
                System.out.print("cancel");
                Thread.currentThread().interrupt();
            }
        }).start();

    }
}
