package chapter5_producer_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: MakerThread
 * @description: 模拟生产者
 * @author: lian.zh
 * @create: 2019-01-10 16:02
 */
@Slf4j
public class MakerThread extends Thread {
    private final Table table;
    private final Random random;
    private static int num = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        random = new Random(seed);
    }

    private static synchronized int nextNo() {
        num++;
        return num;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                String cake = "No." + nextNo();
                table.put(cake);
            } catch (InterruptedException e) {
               log.error("线程：{} 异常中断！", Thread.currentThread().getName());
            }
        }
    }
}
