package chapter7_thread_per_message.exercise;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: MainBlackhole
 * @description: Blackhole测试类
 * @author: lian.zh
 * @create: 2019-01-22 11:07
 */
@Slf4j
public class MainBlackhole {

    public static void main(String[] args) {
        log.info("BEGIN");
        Blackhole.enter(new Object());
        log.info("END");
    }
}
