package chapter3_guarded_suspension.exercise;

import chapter3_guarded_suspension.Request;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: RequestBlockingQueueTimeout
 * @description: BlockingQueue超时版
 * @author: lian.zh
 * @create: 2019-01-09 09:58
 */
@Slf4j
public class RequestBlockingQueueTimeout {

    private final BlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    public Request getRequest() throws InterruptedException {
        Request request = null;
        try {
            request = requests.poll(30, TimeUnit.MILLISECONDS);
            if (request == null)
                throw new LivenessException("从BlockingQueue中获取request超过30毫秒！");
        } catch (InterruptedException e) {
            log.error("获取请求时被中断", e);
            throw e;
        }
        return request;
    }
}
