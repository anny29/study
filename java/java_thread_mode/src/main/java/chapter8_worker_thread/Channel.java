package chapter8_worker_thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: Channel
 * @description: 任务队列
 * @author: lian.zh
 * @create: 2019-01-24 16:49
 */
@Slf4j
public class Channel {

    private final BlockingQueue<Request> requests = new ArrayBlockingQueue<>(100);
    private final ExecutorService threadPool;
    private final int size;

    public Channel(int size) {
        this.size = size;
        threadPool = Executors.newFixedThreadPool(size);
    }

    public void startWorkerThread() {
        for (int i = 0; i < size; i++) {
            threadPool.execute(new WorkerThread(this));
        }
    }

    public void stopWorkerThread() {
        threadPool.shutdownNow();
    }

    public void putRequest(Request request) throws InterruptedException {
        try {
            requests.put(request);
        } catch (InterruptedException e) {
//            log.error("提交请求异常！", e);
            throw e;
        }
    }

    public Request takeRequest() throws InterruptedException {
        Request request = null;
        try {
            request = requests.take();
        } catch (InterruptedException e) {
//            log.error("获取请求异常！", e);
            throw e;
        }
        return request;
    }
}
