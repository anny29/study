package chapter7_thread_per_message;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: Helper
 * @description: 任务执行的方法
 * @author: lian.zh
 * @create: 2019-01-21 11:26
 */
@Slf4j
public class Helper {

    public void handle(int count, char c) {
        log.info("handle {}, {} BEGIN", count, c);
        for (int i = 0; i < count; i++) {
            slowly();
            log.info(String.valueOf(c));
        }
        log.info("handle {}, {} END", count, c);
    }

    private void slowly() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            log.info("睡眠被中断！", e);
        }
    }
}
