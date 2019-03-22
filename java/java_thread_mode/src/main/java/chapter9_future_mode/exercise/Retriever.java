package chapter9_future_mode.exercise;

/**
 * @program: Retriever
 * @description: 练习9-3 获取内容字节数组的类
 * @author: lian.zh
 * @create: 2019-02-13 11:21
 */
public class Retriever {

    public static Content retrieve(String urlStr) {
        return new AsyncContentImpl(urlStr);
    }
}
