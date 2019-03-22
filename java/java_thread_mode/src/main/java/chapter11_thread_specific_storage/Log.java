package chapter11_thread_specific_storage;

/**
 * @program: Log
 * @description: 日志类
 * @author: lian.zh
 * @create: 2019-03-11 16:54
 */
public class Log {

    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    public static void println(String s) {
        getLog().println(s);
    }

    private static TSLog getLog() {
        TSLog log = tsLogCollection.get();
        if (log == null) {
            log = new TSLog(Thread.currentThread().getName());
            tsLogCollection.set(log);
        }
        return log;
    }
}
