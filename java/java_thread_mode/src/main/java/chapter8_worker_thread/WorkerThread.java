package chapter8_worker_thread;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;

import java.util.concurrent.TimeUnit;

/**
 * @program: WorkerThread
 * @description: 工作线程
 * @author: lian.zh
 * @create: 2019-01-24 16:55
 */
@Slf4j
public class WorkerThread implements Runnable {

    private final Channel channel;

    private boolean terminated = false;

    public WorkerThread(Channel channel) {
        this.channel = channel;
    }


    @Override
    public void run() {
        while (!terminated) {
            try {
                channel.takeRequest().execute();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("工作线程中断", e);
                terminated = true;
            }
        }
    }
}
