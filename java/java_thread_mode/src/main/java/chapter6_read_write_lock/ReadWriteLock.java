package chapter6_read_write_lock;

/**
 * @program: ReadWriteLock
 * @description: 读写锁
 * @author: lian.zh
 * @create: 2019-01-15 17:08
 */
public class ReadWriteLock {

    private int readingReaders = 0;
    private int waitingWriters = 0;
    private int writingWriters = 0;
    private boolean preferWriter = true;

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;
    }

    public synchronized void readUnLock() {
        readingReaders--;
        notifyAll();
        preferWriter = true;
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;
        }
        writingWriters++;
    }

    public synchronized void writeUnLock() {
        writingWriters--;
        notifyAll();
        preferWriter = false;
    }
}
