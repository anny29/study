package chapter10_two_phase_termination.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @program: HanoiMain
 * @description: 练习10-7 汉诺塔测试程序
 * @author: lian.zh
 * @create: 2019-03-07 11:23
 */
@Slf4j
public class HanoiMain {

    public static void main(String[] args) {
      log.info("主程序开始");
      try {
          HanoiThread hanoiThread = new HanoiThread();
          hanoiThread.start();

          TimeUnit.SECONDS.sleep(5 );

          log.info("停止汉诺塔线程");
          hanoiThread.shutdownRequest();

          hanoiThread.join();
      } catch (InterruptedException e) {
          log.error("主程序睡眠中断", e);
      }
      log.info("主程序停止");
    }
}
