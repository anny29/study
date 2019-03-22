package chapter7_thread_per_message.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: Service
 * @description: 模拟窗口按钮点击执行的动作
 * @author: lian.zh
 * @create: 2019-01-22 10:16
 */
@Slf4j
public class Service {

    public static void service() {
        log.info("service");
        for (int i = 0; i < 50; i++) {
            log.info(".");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                log.error("睡眠异常", e);
            }
        }
        log.info("done.");
    }
}
