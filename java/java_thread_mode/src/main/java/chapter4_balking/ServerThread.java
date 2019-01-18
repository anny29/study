package chapter4_balking;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: ServerThread
 * @description: 模拟自动保存的线程
 * @author: lian.zh
 * @create: 2019-01-07 17:41
 */
@Slf4j
public class ServerThread extends Thread {

    private final Data data;
    private final Random random = new Random();

    public ServerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            try {
                data.save();
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                //log.info("自动保存，第{}次循环", i);
            } catch (InterruptedException e) {
                log.error("睡眠中断！", e);
            } catch (IOException e) {
                log.error("保存修改内容异常！", e);
            }
        }
    }
}
