package chapter6_read_write_lock;

/**
 * @program: Main
 * @description: 测试读写锁的类
 * @author: lian.zh
 * @create: 2019-01-16 09:31
 */
public class Main {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Data data = new Data(readWriteLock, 10);
        new ReadThread("读取线程A", data).start();
        new ReadThread("读取线程B", data).start();
        new ReadThread("读取线程C", data).start();
        new ReadThread("读取线程D", data).start();
        new ReadThread("读取线程E", data).start();
        new ReadThread("读取线程F", data).start();

        new WriteThread("写入线程A", data, "cat").start();
        new WriteThread("写入线程B", data, "DOG").start();


    }
}
