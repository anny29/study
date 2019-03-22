package chapter11_thread_specific_storage;

/**
 * @program: TSLog
 * @description: 日志类的代理对象
 * @author: lian.zh
 * @create: 2019-03-11 16:45
 */
public class TSLog {

    private String logPrefix;

    public TSLog(String logPrefix) {
        this.logPrefix = logPrefix;
    }

    public void println(String s) {
        System.out.println(logPrefix + ": " + s);
    }
}
