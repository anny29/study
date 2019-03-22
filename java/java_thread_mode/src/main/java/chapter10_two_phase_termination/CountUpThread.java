package chapter10_two_phase_termination;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: CountUpThread
 * @description: 模拟计数的类
 * @author: lian.zh
 * @create: 2019-03-05 11:09
 */
@Slf4j
public class CountUpThread extends Thread {

    private volatile boolean isShutdown = false;

    private int count;

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }

        } catch (InterruptedException e) {
            log.error("线程中断", e);
        } finally {
            doShutdown();
        }
    }

    public void shutdownRequest() {
        isShutdown = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return isShutdown;
    }

    private void doWork() throws InterruptedException {
        count++;
        log.info("当前计数：{}", count);
        TimeUnit.MILLISECONDS.sleep(500);
    }

    private void doShutdown() {
        log.info("线程完成清理工作，当前计数：{}", count);
    }
}
