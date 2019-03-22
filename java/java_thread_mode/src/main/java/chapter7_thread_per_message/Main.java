package chapter7_thread_per_message;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: Main
 * @description: 测试类
 * @author: lian.zh
 * @create: 2019-01-21 16:38
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Main Begin");
        Helper helper = new Helper();
        Host host = new Host(helper);
        host.request(3, 'a');
        host.request(4, 'b');
        host.request(5, 'c');
        log.info("Main End");
    }
}
