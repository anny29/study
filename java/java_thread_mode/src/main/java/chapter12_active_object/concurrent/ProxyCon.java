package chapter12_active_object.concurrent;

import chapter12_active_object.ActiveObject;
import chapter12_active_object.Result;
import chapter12_active_object.Servant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @program: ProxyCon
 * @description: 使用concurrent包的代理类
 * @author: lian.zh
 * @create: 2019-03-19 10:11
 */
public class ProxyCon implements ActiveObjectCon {

    private final ExecutorService executorService;
    private final ServantCon servant;

    public ProxyCon(ExecutorService executorService, ServantCon servant) {
        this.executorService = executorService;
        this.servant = servant;
    }

    @Override
    public Future<String> makeString(char c, int count) {
        Future<String> future = executorService.submit(() -> servant.makeString(c, count));
//        Future<String> future = executorService.submit(servant::makeString);
        return future;
    }

    @Override
    public void displayString(String msg) {
        executorService.execute(() -> servant.displayString(msg));
    }
}
