package chapter9_future_mode;

import annotation.TimeCost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

/**
 * @program: Host
 * @description: 模拟服务端
 * @author: lian.zh
 * @create: 2019-02-11 16:28
 */
@Slf4j
@Component
public class Host implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @TimeCost
    public Data request(final char c, final int count) {
        /*final FutureData future = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RealData realData = new RealData(c, count);
//                RealData realData = applicationContext.getBean(RealData.class, c, count);
                    future.setData(realData);
                } catch (Exception e) {
                    future.setException(e);
                }
            }
        }).start();
        return future;*/
        FutureDataCon futureDataCon = new FutureDataCon(new Callable<RealData>() {
            @Override
            public RealData call() throws Exception {
                return new RealData(c, count);
            }
        });
        new Thread(futureDataCon).start();
        return futureDataCon;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
