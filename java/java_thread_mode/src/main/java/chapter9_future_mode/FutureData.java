package chapter9_future_mode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @program: FutureData
 * @description: 期货对象
 * @author: lian.zh
 * @create: 2019-02-11 16:01
 */
@Slf4j
public class FutureData implements Data {

    private RealData realData;
    private boolean ready = false;
    private Exception exception;

    @Override
    public synchronized String getContent() throws ExecutionException {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("等待异常！", e);
            }
        }

        if (exception != null) {
            throw new ExecutionException(exception);
        }

        return realData.getContent();
    }

    public synchronized void setData(RealData realData) {
        if (ready)
            return;
        ready = true;
        this.realData = realData;
        notifyAll();
    }

    public synchronized void setException(Exception exception) {
        if (ready)
            return;
        ready = true;
        this.exception = exception;
        notifyAll();
    }
}
