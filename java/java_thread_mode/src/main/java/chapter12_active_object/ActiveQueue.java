package chapter12_active_object;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ActiveQueue
 * @description: 消息队列
 * @author: lian.zh
 * @create: 2019-03-15 11:27
 */
@Slf4j
class ActiveQueue {

    private MethodRequest[] requests;

    private int count;

    private int head;

    private int tail;

    public ActiveQueue(int size) {
        requests = new MethodRequest[size];
    }

    public synchronized void put(MethodRequest request) {
        while (count >= requests.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("存入请求等待异常中断", e);
            }
        }
        requests[head] = request;
        head = (++head) % requests.length;
        count++;
        notifyAll();
    }

    public synchronized MethodRequest take() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("取出请求等待异常中断", e);
            }
        }
        MethodRequest request = requests[tail];
        tail = (++tail) % requests.length;
        count--;
        notifyAll();
        return request;
    }
}
