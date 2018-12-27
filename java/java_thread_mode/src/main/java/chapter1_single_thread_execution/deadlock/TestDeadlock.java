package chapter1_single_thread_execution.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @program: TestDeadlock
 * @description: 测试死锁情况
 * @author: lian.zh
 * @create: 2018-11-23 10:45
 */
public class TestDeadlock {

    public static void main(String[] args) throws InterruptedException {
        Tool fork = new Tool("叉子");
        Tool spoon = new Tool("勺子");
        new EaterThread("张三", fork, spoon).start();
        TimeUnit.SECONDS.sleep(3);
        new EaterThread("李四", spoon, fork).start();
    }
}
