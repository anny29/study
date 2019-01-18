package chapter6_read_write_lock;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: ReadThread
 * @description: 模拟读取者
 * @author: lian.zh
 * @create: 2019-01-15 17:41
 */
@Slf4j
public class ReadThread extends Thread {

    private final Data data;

    public ReadThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                log.info("线程：{}读取字符串：{}", Thread.currentThread().getName(), data.read());
            } catch (InterruptedException e) {
                log.error("线程: {}读取字符异常！");
            }
        }
    }
}
