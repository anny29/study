package chapter8_worker_thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: MakeStrClientThread
 * @description: 请求者
 * @author: lian.zh
 * @create: 2019-01-24 17:21
 */
@Slf4j
public class ClientThread extends Thread {
    private final Channel channel;

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                channel.putRequest(new Request(getName() + "_" + i));
                i++;
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("睡眠异常", e);
            }
        }
    }
}
