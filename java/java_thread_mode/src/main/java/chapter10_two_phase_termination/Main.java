package chapter10_two_phase_termination;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: Main
 * @description: 测试计数类
 * @author: lian.zh
 * @create: 2019-03-05 15:34
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        log.info("Main 开始");
        CountUpThread countUpThread = new CountUpThread();
        countUpThread.start();
        TimeUnit.SECONDS.sleep(5);
        countUpThread.shutdownRequest();
        countUpThread.join();
        log.info("Main 结束");
    }
}
