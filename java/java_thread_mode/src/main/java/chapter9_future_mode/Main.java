package chapter9_future_mode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

/**
 * @program: Main
 * @description: 测试类
 * @author: lian.zh
 * @create: 2019-02-11 16:48
 */
@SpringBootApplication(scanBasePackages = {"aspect", "chapter9_future_mode"})
@Slf4j
public class Main implements CommandLineRunner {

    @Autowired
    private Host host;

    public static void main(String[] args) {
        new SpringApplication(Main.class).run();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Main Begin.");
        Data data1 = host.request('A', -1);
        Data data2 = host.request('B', 10);
        Data data3 = host.request('C', 15);

        TimeUnit.SECONDS.sleep(1);

        log.info("data1 content:{}", data1.getContent());
        log.info("data2 content:{}", data2.getContent());
        log.info("data3 content:{}", data3.getContent());

        log.info("Main End.");
    }
}
