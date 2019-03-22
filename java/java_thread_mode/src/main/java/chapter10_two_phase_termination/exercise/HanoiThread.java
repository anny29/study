package chapter10_two_phase_termination.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: HanoiThread
 * @description: 练习10-7 汉诺塔
 * @author: lian.zh
 * @create: 2019-03-07 10:32
 */
@Slf4j
public class HanoiThread extends Thread {

    private volatile boolean shutdownRequested = false;

    private long requestShutdownTime = 0;

    @Override
    public void run() {
        try {
            for (int level = 0; !isShutdownRequested(); level++) {
                System.out.println("=== Level: " + level + " ===");
                doWork(level, 'A', 'B', 'C');
                System.out.println();
            }
        } catch (InterruptedException e) {
            log.error("睡眠中断！", e);
        } finally {
            doShutdown();
        }
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    public void shutdownRequest() {
        shutdownRequested = true;
        requestShutdownTime = System.currentTimeMillis();
        interrupt();
    }

    private void doWork(int level, char posA, char posB, char posC) throws InterruptedException {
        if (level > 0) {
            /*if (!isShutdownRequested()) {
                doWork(level - 1, posA, posC, posB);
            }
            System.out.print(posA + "->" + posB + " ");
           *//* if (!isShutdownRequested()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }*//*
            if (!isShutdownRequested()) {
                doWork(level - 1, posC, posB, posA);
            }*/
            if (isShutdownRequested()) {
                throw new InterruptedException();
            }
            doWork(level - 1, posA, posC, posB);
            System.out.print(posA + "->" + posB + " ");
//            TimeUnit.MILLISECONDS.sleep(100);
            doWork(level - 1, posC, posB, posA);
        }
    }

    private void doShutdown() {
        long currentTime = System.currentTimeMillis();
        log.info("从收到暂停请求到最终结束，耗时：{}ms", currentTime - requestShutdownTime);
    }
}
