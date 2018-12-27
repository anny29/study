package chapter1_single_thread_execution.gate;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: Gate
 * @description: 模拟门 记录行人通过和总次数
 * @author: lian.zh
 * @create: 2018-11-20 10:35
 */
@Slf4j
public class Gate {
    private String name = "Nobody";
    private String address = "Nowhere";
    private int counter = 0;
    private Mutex mutex = new Mutex();

    public void pass(String name, String address) {
        try {
            mutex.lock();
            counter++;
            this.name = name;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("线程睡眠异常，线程ID：{}", e, Thread.currentThread().getId());
            }
            this.address = address;
            check();
        } finally {
            mutex.unlock();
        }
    }

    @Override
    public String toString() {
        String str = null;
        try {
            mutex.lock();
            str = String.format("No.%d: %s, %s", counter, name, address);
        } finally {
            mutex.unlock();
        }
        return str;
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            log.error("****Broken*****{}", toString());
        }
    }
}
