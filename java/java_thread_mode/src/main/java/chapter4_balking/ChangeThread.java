package chapter4_balking;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @program: ChangeThread
 * @description: 模拟用户，输入后主动保存文件
 * @author: lian.zh
 * @create: 2019-01-08 10:19
 */
@Slf4j
public class ChangeThread extends Thread {

    private final Data data;


    public ChangeThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            try {
                data.change("No." + i);
                TimeUnit.MILLISECONDS.sleep(1000);
                data.save();
            } catch (InterruptedException e) {
                log.error("睡眠中断！", e);
            } catch (IOException e) {
                log.error("保存修改内容异常！", e);
            }
        }
    }
}
