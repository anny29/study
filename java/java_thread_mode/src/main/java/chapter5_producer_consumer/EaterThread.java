package chapter5_producer_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: EaterThread
 * @description: 模拟消费者
 * @author: lian.zh
 * @create: 2019-01-10 16:22
 */
@Slf4j
public class EaterThread extends Thread {
    private final Table table;
    private final Random random;

    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            try {
                String cake = table.take();
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));

            } catch (InterruptedException e) {
                log.error("线程：{} 中断异常！", e, Thread.currentThread().getName());
            }

        }
    }
}
