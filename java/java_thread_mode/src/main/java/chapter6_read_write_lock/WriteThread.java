package chapter6_read_write_lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: WriteThread
 * @description: 模拟写入
 * @author: lian.zh
 * @create: 2019-01-16 09:15
 */
@Slf4j
public class WriteThread extends Thread {

    private final Data data;
    private final String writeStr;
    private int index = 0;
    private final Random random = new Random();

    public WriteThread(String name, Data data, String writeStr) {
        super(name);
        this.data = data;
        this.writeStr = writeStr;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                char writeChar = nextChar();
                data.write(writeChar);
                log.info("线程：{} 写入数据：{}", Thread.currentThread().getName(), writeChar);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                log.error("线程：{}写入数据异常！", e, Thread.currentThread().getName());
            }
        }
    }

    private char nextChar() {
        char retChar = writeStr.charAt(index);
        index++;
        index = index % writeStr.length();
        return retChar;
    }

}
