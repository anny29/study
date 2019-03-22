package chapter9_future_mode.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: AsyncContentImpl
 * @description: 练习9-3 异步读取数据
 * @author: lian.zh
 * @create: 2019-02-13 14:56
 */
@Slf4j
public class AsyncContentImpl implements Content {

    private FutureTask<SyncContentImpl> futureContent;

    public AsyncContentImpl(String urlStr) {
        futureContent = new FutureTask<>(new Callable<SyncContentImpl>() {
            @Override
            public SyncContentImpl call() throws Exception {
                return new SyncContentImpl(urlStr);
            }
        });
        new Thread(futureContent).start();
    }

    @Override
    public byte[] getBytes() {
        byte[] bytes = null;
        try {
            bytes = futureContent.get().getBytes();
        } catch (InterruptedException e) {
            log.error("中断异常", e);
        } catch (ExecutionException e) {
            log.error("执行异常", e);
        }
        return bytes;
    }
}
