package chapter6_read_write_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: DataLock
 * @description: 使用concurrent包Readwritelock的实现
 * @author: lian.zh
 * @create: 2019-01-16 15:18
 */
public class DataLock {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final char[] buffer;

    public DataLock(int size) {
        buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() {
        readLock.lock();
        try {
            return new char[1];
        } finally {
            readLock.unlock();
        }
    }

    public void write(char c) {
        writeLock.lock();
        try {

        } finally {
            writeLock.unlock();
        }
    }
}
