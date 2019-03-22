package chapter8_worker_thread.exercise;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: MainMyFrame
 * @description: 习题8-5 窗口程序测试
 * @author: lian.zh
 * @create: 2019-01-24 15:32
 */
@Slf4j
public class MainMyFrame {

    public static void main(String[] args) {
        log.info("Main Start");
        new MyFrame();
        log.info("Main End");
    }
}
