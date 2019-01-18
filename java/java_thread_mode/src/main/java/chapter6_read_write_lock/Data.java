package chapter6_read_write_lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: Data
 * @description: 模拟共享资源
 * @author: lian.zh
 * @create: 2019-01-15 17:23
 */
public class Data {
    private final ReadWriteLock lock;
    private final char[] buffer;
    private Random random = new Random();

    public Data(ReadWriteLock lock, int size) {
        this.lock = lock;
        buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();
        } finally {
            lock.readUnLock();
        }
    }

    public void write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(c);
        } finally {
            lock.writeUnLock();
        }
    }

    private char[] doRead() throws InterruptedException {
        char[] newBuffer = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        slowly();
        return newBuffer;
    }

    private void doWrite(char c) throws InterruptedException {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(50));
    }
}
