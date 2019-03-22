package chapter9_future_mode;

import annotation.TimeCost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: RealData
 * @description: 真实数据对象，创建耗时
 * @author: lian.zh
 * @create: 2019-02-11 15:44
 */
@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RealData implements Data {

    private String content;

    @TimeCost
    public RealData(char c, int count) {
        log.info("线程：{}开始创建RealData, char:{}, count:{}", Thread.currentThread().getName(), c, count);
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
        }
        content = new String(buffer);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            log.error("睡眠异常", e);
        }
    }

    @Override
    public String getContent() {
        return content;
    }
}
