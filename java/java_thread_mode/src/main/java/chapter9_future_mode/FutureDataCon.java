package chapter9_future_mode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: FutureDataCon
 * @description: 使用FutureTask实现
 * @author: lian.zh
 * @create: 2019-02-13 09:11
 */
@Slf4j
public class FutureDataCon extends FutureTask<RealData> implements Data {

    public FutureDataCon(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public String getContent() throws ExecutionException {
        String content = null;
        try {
            content = get().getContent();
        } catch (InterruptedException e) {
            log.error("中断异常", e);
        } catch (ExecutionException e) {
            log.error("执行异常", e);
            throw e;
        }
        return content;
    }
}
