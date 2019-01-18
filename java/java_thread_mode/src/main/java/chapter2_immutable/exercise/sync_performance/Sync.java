package chapter2_immutable.exercise.sync_performance;

/**
 * @program: Sync
 * @description: toString()同步类
 * @author: lian.zh
 * @create: 2019-01-02 10:00
 */
public class Sync {

    private final String name = "Sync";

    @Override
    public synchronized String toString() {
        return "[" + name + "]";
    }
}
