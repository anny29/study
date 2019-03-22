package chapter12_active_object;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: FutureResult
 * @description: 立即返回的future对象
 * @author: lian.zh
 * @create: 2019-03-18 09:47
 */
@Slf4j
public class FutureResult<T> implements Result<T> {

    private ConcreteResult<T> realResult;
    private boolean ready = false;

    @Override
    public synchronized T getResult() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("等待处理结果时被中断", e);
            }
        }
        return realResult.getResult();
    }

    public synchronized void setResult(ConcreteResult realResult) {
        if (ready)
            return;
        this.realResult = realResult;
        notifyAll();
    }
}
