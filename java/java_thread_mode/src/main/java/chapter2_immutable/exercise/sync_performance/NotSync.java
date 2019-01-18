package chapter2_immutable.exercise.sync_performance;

/**
 * @program: NotSync
 * @description: 非同步类
 * @author: lian.zh
 * @create: 2019-01-02 10:03
 */
public class NotSync {

    private final String name = "NotSync";

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
