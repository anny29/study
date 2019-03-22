package chapter12_active_object;

/**
 * @program: SchedulerThread
 * @description: 任务调度类
 * @author: lian.zh
 * @create: 2019-03-15 16:42
 */
class SchedulerThread extends Thread {

    private ActiveQueue activeQueue;

    public SchedulerThread(ActiveQueue activeQueue) {
        this.activeQueue = activeQueue;
    }

    @Override
    public void run() {
        while (true) {
            MethodRequest request = activeQueue.take();
            request.execute();
        }
    }

    public void invoke(MethodRequest request) {
        activeQueue.put(request);
    }
}
