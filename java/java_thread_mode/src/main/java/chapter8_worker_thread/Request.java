package chapter8_worker_thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: Request
 * @description: 请求
 * @author: lian.zh
 * @create: 2019-01-24 16:50
 */
@Slf4j
public class Request {

    private final String msg;

    public Request(String msg) {
        this.msg = msg;
    }

    public void execute() {
        log.info("{} print: {}", Thread.currentThread().getName(), msg);
    }
}
