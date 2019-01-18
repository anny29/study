package chapter5_producer_consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: Table
 * @description: 模拟存放蛋糕的桌子
 * @author: lian.zh
 * @create: 2019-01-10 15:41
 */
@Slf4j
public class Table {
    private final String[] cakes;
    private int head;
    private int tail;
    private int count;

    public Table(int size) {
        cakes = new String[size];
    }

    public synchronized String take() throws InterruptedException {
        while (count == 0) {
            log.debug("桌子上没有蛋糕，{}开始等待蛋糕师放置蛋糕", Thread.currentThread().getName());
            wait();
        }
        String cake = cakes[tail];
        tail = (tail + 1) % cakes.length;
        count--;
        log.info("线程：{} 拿走了蛋糕：{}", Thread.currentThread().getName(), cake);
        notifyAll();
        return cake;
    }

    public synchronized void put(String cake) throws InterruptedException {
        while (count >= cakes.length) {
            log.debug("桌子上已有 {}个蛋糕，{}开始等待消费者拿走蛋糕", cakes.length, Thread.currentThread().getName());
            wait();
        }
        cakes[head] = cake;
        head = (head + 1) % cakes.length;
        count++;
        log.info("线程：{} 创建了蛋糕：{}", Thread.currentThread().getName(), cake);
        notifyAll();
    }

    public synchronized void clear() {
        for (int i = 0; i < cakes.length; i++)
            cakes[i] = null;
        count = 0;
        head = 0;
        tail = 0;
        notifyAll();
    }
}
