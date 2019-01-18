package chapter5_producer_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @program: TableBlockingQueue
 * @description: 桌子的BlockingQueue实现版本
 * @author: lian.zh
 * @create: 2019-01-11 10:35
 */
@Slf4j
public class TableBlockingQueue {

    private final BlockingQueue<String> table;

    public TableBlockingQueue(int cakeNumb) {
        table = new ArrayBlockingQueue<>(cakeNumb);
    }

    public String take() throws InterruptedException {
        return table.take();
    }

    public void put(String cake) throws InterruptedException {
        table.put(cake);
    }
}
