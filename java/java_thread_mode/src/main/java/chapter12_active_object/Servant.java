package chapter12_active_object;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @program: Servant
 * @description: 主动对象的实现类
 * @author: lian.zh
 * @create: 2019-03-15 11:09
 */
@Slf4j
public class Servant implements ActiveObject {

    @Override
    public Result<String> makeString(int i, char c) {
        StringBuilder sbd = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sbd.append(c);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            log.error("睡眠中断", e);
        }
        return new ConcreteResult<>(sbd.toString());
    }

    @Override
    public void display(String msg) {
        log.info("Servant msg: {}", msg);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            log.error("睡眠中断！", e);
        }
    }
}
