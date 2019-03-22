package chapter8_worker_thread;

import java.util.concurrent.TimeUnit;

/**
 * @program: Main
 * @description: 测试类
 * @author: lian.zh
 * @create: 2019-01-24 17:35
 */
public class Main {

    public static void main(String[] args) {
        Channel channel = new Channel(5);
        new ClientThread("Alice", channel).start();
        new ClientThread("Bob", channel).start();
        new ClientThread("Clark", channel).start();
        channel.startWorkerThread();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {

        }
        channel.stopWorkerThread();
    }
}
