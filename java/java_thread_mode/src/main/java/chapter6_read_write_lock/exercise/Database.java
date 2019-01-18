package chapter6_read_write_lock.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: Database
 * @description: 模拟数据库，使用读写锁控制
 * @author: lian.zh
 * @create: 2019-01-16 16:24
 */
public class Database<K, V> {

    private final Map<K, V> map = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true /* false*/);
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private void clear() {
        writeLock.lock();
        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }

    private void assign(K key, V value) {
        writeLock.lock();
        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public V retrieve(K key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }
}
