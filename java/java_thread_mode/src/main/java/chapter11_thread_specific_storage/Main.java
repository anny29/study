package chapter11_thread_specific_storage;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Main
 * @description: 测试类
 * @author: lian.zh
 * @create: 2019-03-11 17:05
 */
public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <=3; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int n = 1; n <=3; n++) {
                        Log.println("==" + n + "==");
                    }
                }
            }, "线程" + i);
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.start();
        }
    }
}
