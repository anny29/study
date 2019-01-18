package chapter3_guarded_suspension;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: ServerThread
 * @description: 消费请求线程
 * @author: lian.zh
 * @create: 2019-01-04 15:49
 */
@Slf4j
public class ServerThread extends Thread {

    private final RequestQueue requestQueue;

    private final Random random;

    private volatile boolean runFlag = true;

    public ServerThread(RequestQueue requestQueue, long seed) {
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (long i = 0; i < 1000000L && runFlag; i++) {
            try {
                Request request = requestQueue.getRequest();
                log.info("获得请求：{}", request);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                log.error("睡眠异常！", e);
                break;
            }
        }
    }

    public void setRunFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }
}
