package chapter12_active_object;

/**
 * @program: Proxy
 * @description: 主动对象接口的代理实现类，将方法调用抽象为统一请求
 * @author: lian.zh
 * @create: 2019-03-18 10:42
 */
public class Proxy implements ActiveObject {

    private SchedulerThread schedulerThread;
    private Servant servant;

    public Proxy(SchedulerThread schedulerThread, ActiveQueue activeQueue, Servant servant) {
        this.schedulerThread = schedulerThread;
        this.servant = servant;
    }

    @Override
    public Result<String> makeString(int i, char c) {
        FutureResult<String> futureResult = new FutureResult<>();
        MakeStringRequest makeStringRequest = new MakeStringRequest(servant, i, c, futureResult);
        schedulerThread.invoke(makeStringRequest);
        return futureResult;
    }

    @Override
    public void display(String msg) {
        DisplayStringRequest displayStringRequest = new DisplayStringRequest(servant, msg);
        schedulerThread.invoke(displayStringRequest);
    }
}
