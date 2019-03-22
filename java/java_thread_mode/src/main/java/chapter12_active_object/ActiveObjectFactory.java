package chapter12_active_object;

/**
 * @program: ActiveObjectFactory
 * @description: 主动对象工厂类
 * @author: lian.zh
 * @create: 2019-03-18 10:57
 */
public class ActiveObjectFactory {

    public static ActiveObject createActiveObject() {
        Servant servant = new Servant();
        ActiveQueue activeQueue = new ActiveQueue(5);
        SchedulerThread schedulerThread = new SchedulerThread(activeQueue);
        schedulerThread.start();
        Proxy proxy = new Proxy(schedulerThread, activeQueue, servant);
        return proxy;
    }
}
