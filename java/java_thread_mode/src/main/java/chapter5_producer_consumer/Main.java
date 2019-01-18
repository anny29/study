package chapter5_producer_consumer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: Main
 * @description: 测试类
 * @author: lian.zh
 * @create: 2019-01-10 16:42
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Table table = new Table(3);
        List<MakerThread> makers = new ArrayList<>();
        makers.add(new MakerThread("蛋糕师A", table, 123741));
        makers.add(new MakerThread("蛋糕师B", table, 963852));
        makers.add(new MakerThread("蛋糕师C", table, 852951));
        for (MakerThread makerThread : makers)
            makerThread.start();

        List<EaterThread> eaters = new ArrayList<>();
        eaters.add(new EaterThread("消费者A", table, 741896));
        eaters.add(new EaterThread("消费者B", table, 223112));
        eaters.add(new EaterThread("消费者C", table, 963123));
        for (EaterThread eaterThread : eaters)
            eaterThread.start();

       /*  在中断异常未抛出的情况下，是停止不了的
       try {
            TimeUnit.SECONDS.sleep(10);
            log.info("中断蛋糕师、消费者线程。");
        } catch (InterruptedException e) {

        }

        for (MakerThread makerThread : makers)
            makerThread.interrupt();

        for (EaterThread eaterThread : eaters)
            eaterThread.interrupt();*/
    }
}
