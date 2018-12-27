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

    private final Semaphore semaphore;

    public Mutex() {
        semaphore = new Semaphore(1);
    }

    public void lock() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            log.error("获取信号量异常！", e);
        }
    }

    public void unlock() {
        semaphore.release();
    }
}
