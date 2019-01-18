package chapter4_balking;

/**
 * @program: Main
 * @description: 测试类
 * @author: lian.zh
 * @create: 2019-01-08 10:41
 */
public class Main {

    public static void main(String[] args) {
        Data data = new Data("Balking_test.txt");
        new ChangeThread("Changer", data).start();
        new ServerThread("Server", data).start();
    }
}
