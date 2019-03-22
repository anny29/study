package chapter12_active_object.exercise;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: ActiveAddObject
 * @description: 习题12-2 加法
 * @author: lian.zh
 * @create: 2019-03-18 17:09
 */
public class ActiveAddObject {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public Future<String> add(String x, String y) {
        Future<String> result = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                BigInteger xInt = new BigInteger(x);
                BigInteger yInt = new BigInteger(y);
                BigInteger rInt = xInt.add(yInt);

                return rInt.toString();
            }
        });
        return result;
    }
}
