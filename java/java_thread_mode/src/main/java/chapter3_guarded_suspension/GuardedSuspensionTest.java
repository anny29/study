package chapter3_guarded_suspension;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: GuardedSuspensionTest
 * @description: 守护暂停模式测试类
 * @author: lian.zh
 * @create: 2019-01-04 15:52
 */
@Slf4j
public class GuardedSuspensionTest {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        ClientThread clientThread = new ClientThread(requestQueue, 1000L);
        ServerThread serverThread = new ServerThread(requestQueue, 1500L);
        clientThread.start();
        serverThread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {

        }

        log.info("停止线程的运行！");
        clientThread.interrupt();
        serverThread.interrupt();
    }
}
