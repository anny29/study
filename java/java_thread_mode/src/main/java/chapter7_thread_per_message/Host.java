package chapter7_thread_per_message;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: Host
 * @description: 模仿接收请求的主机
 * @author: lian.zh
 * @create: 2019-01-21 16:15
 */
@Slf4j
public class Host {

    private final Helper helper;

    public Host(Helper helper) {
        this.helper = helper;
    }

    public void request(final int count, final char c) {
        log.info("request {}, {} BEGIN", count, c);
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        ).start();
        log.info("request {}, {} END", count, c);
    }
}
