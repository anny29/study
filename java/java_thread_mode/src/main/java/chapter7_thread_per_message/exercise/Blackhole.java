package chapter7_thread_per_message.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: Blackhole
 * @description: 练习测试类
 * @author: lian.zh
 * @create: 2019-01-22 11:01
 */
@Slf4j
public class Blackhole {

    public static void enter(Object obj) {
      log.info("Step 1");
      magic(obj);
      log.info("Step 2");
      synchronized (obj) {
          log.info("Step 3 (never reached here)");
      }

    }

    public static void magic01(final Object obj) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    log.info("启动线程获取锁");
                        while (true) {

                        }
                }
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.error("sleep 异常", e);
        }
    }

    public static void magic(final Object object) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    synchronized (this) {
                        this.setName("Locked");
                        this.notifyAll();
                    }
                    while (true) {

                    }
                }
            }
        };
        synchronized (thread) {
            thread.setName("");
            thread.start();
            while (thread.getName().equals("")) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    log.error("wait()异常", e);
                }
            }
        }
    }
}
