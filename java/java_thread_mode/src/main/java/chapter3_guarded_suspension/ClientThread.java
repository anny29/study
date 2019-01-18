package chapter3_guarded_suspension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: ClientThread
 * @description: 发送请求线程
 * @author: lian.zh
 * @create: 2019-01-04 15:32
 */
public class ClientThread extends Thread {

    private static final Logger log = LoggerFactory.getLogger(ClientThread.class);

    private final RequestQueue requestQueue;

    private final Random random;

    private volatile boolean runFlag = true;

    public ClientThread(RequestQueue requestQueue, long seed) {
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
       for (long i = 0; i < 1000000L && runFlag; i++) {
           Request request = new Request("No." + i);
           requestQueue.putRequest(request);
           log.info("创建请求：{}", request);
           try {
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
