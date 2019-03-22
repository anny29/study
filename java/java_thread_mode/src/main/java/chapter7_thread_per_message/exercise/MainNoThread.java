package chapter7_thread_per_message.exercise;

import chapter7_thread_per_message.Helper;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: MainNoThread
 * @description: 不启用子线程的类
 * @author: lian.zh
 * @create: 2019-01-21 17:30
 */
@Slf4j
public class MainNoThread {

    public static void main(String[] args) {
        log.info("MainNoThread Begin");
        Helper helper = new Helper();
        helper.handle(3, 'a');
        helper.handle(4, 'b');
        helper.handle(5, 'c');
        log.info("MainNoThread End");
    }
}
