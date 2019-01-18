package chapter3_guarded_suspension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: RequestQueue
 * @description: 请求队列
 * @author: lian.zh
 * @create: 2019-01-04 15:27
 */
public class RequestQueue {

    private static final Logger log = LoggerFactory.getLogger(RequestQueue.class);

    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() throws InterruptedException {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("调用wait()异常！", e);
                throw e;
            }
        }
        return queue.remove();
    }

    public synchronized void  putRequest(Request request) {
        queue.add(request);
        notifyAll();
    }
}
