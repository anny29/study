package chapter12_active_object;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: MakeStrClientThread
 * @description: 发出请求的线程
 * @author: lian.zh
 * @create: 2019-03-18 15:17
 */
@Slf4j
public class MakeStrClientThread extends Thread {

    private ActiveObject activeObject;

    public MakeStrClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            Result<String> result = activeObject.makeString(i, getName().charAt(0));
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                log.error("睡眠中断", e);
            }
            log.info("Make String: {}", result.getResult());
        }
    }
}
