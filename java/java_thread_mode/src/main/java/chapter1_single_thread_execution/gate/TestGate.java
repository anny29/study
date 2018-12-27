package chapter1_single_thread_execution.gate;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: TestGate
 * @description: 测试行人通过同一个门
 * @author: lian.zh
 * @create: 2018-11-20 11:18
 */
@Slf4j
public class TestGate {

    public static void main(String[] args) {
        log.info("测试开始！");
        Gate gate = new Gate();
        new UserThread("Alice", "Alaska", gate).start();
        new UserThread("Bobby", "Brazil", gate).start();
        new UserThread("Chris", "Canada", gate).start();
    }
}
