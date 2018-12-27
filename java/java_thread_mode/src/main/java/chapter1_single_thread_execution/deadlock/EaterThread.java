package chapter1_single_thread_execution.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: EaterThread
 * @description: 模拟进餐者
 * @author: lian.zh
 * @create: 2018-11-23 09:49
 */
@Slf4j
public class EaterThread extends Thread {
    private String name;
    private final Tool lefthand;
    private final Tool righthand;

    public EaterThread(String name, Tool lefthand, Tool righthand) {
        this.name = name;
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        synchronized (lefthand) {
            log.info("{} 拿起了 {} (左手)." , name, lefthand);
           /* try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("{}拿起左手餐具后停顿异常！", e, name);
            }*/
            synchronized (righthand) {
                log.info("{} 拿起了 {} (右手)." , name, righthand);
                log.info("{} 开始用餐!", name);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    log.error("{}用餐时异常！", e, name);
                }
                log.info("{} 放下了 {} (右手.)", name, righthand);
            }
            log.info("{} 放下了 {} (左手.)", name, lefthand);
        }
        Lock lock = new ReentrantLock();
    }
}
