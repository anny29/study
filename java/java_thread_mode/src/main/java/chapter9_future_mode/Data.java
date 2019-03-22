package chapter9_future_mode;

import java.util.concurrent.ExecutionException;

/**
 * @program: Data
 * @description: 获取数据接口
 * @author: lian.zh
 * @create: 2019-02-11 15:43
 */
public interface Data {

    public String getContent() throws ExecutionException;
}
