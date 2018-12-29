package chapter1_single_thread_execution.gate;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @program: Mutex
 * @description: 互斥类
 * @author: lian.zh
 * @create: 2018-11-23 11:04
 */
@Slf4j
public class Mutex {

    private long lock;
    private Thread owner;

    public synchronized void lock() {
        Thread me = Thread.currentThread();
        if (lock > 0 && owner != me) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("获取锁异常，线程ID：{}", e, me.getId());
            }
        }
        assert lock == 0 || owner == me;
        lock++;
        owner = me;
    }

    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        if (lock == 0 || owner != me) {
            return;
        }
        assert lock > 0 && owner == me;
        lock--;
        if (lock == 0) {
            notifyAll();
            owner = null;
        }
    }
}
