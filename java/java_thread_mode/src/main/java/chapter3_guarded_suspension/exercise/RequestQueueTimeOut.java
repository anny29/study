package chapter3_guarded_suspension.exercise;

import chapter3_guarded_suspension.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: RequestQueueTimeOut
 * @description: wait超时版本
 * @author: lian.zh
 * @create: 2019-01-09 09:48
 */
public class RequestQueueTimeOut {
    private final Queue<Request> requestQueue = new LinkedList<>();
    private final long TIMEOUT = 3000L;

    public synchronized Request getRequest() {
        long start = System.currentTimeMillis();
        while (requestQueue.peek() == null) {
            long rest = TIMEOUT - (System.currentTimeMillis() - start);
            if (rest < 0 )
                throw new LivenessException("获取请求对象超过3秒！");
            try {
                wait(rest);
            } catch (InterruptedException e) {
            }

        }
        return requestQueue.remove();
    }
}
