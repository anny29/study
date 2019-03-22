package chapter12_active_object;

/**
 * @program: Main
 * @description: 主动对象测试类
 * @author: lian.zh
 * @create: 2019-03-18 14:47
 */
public class Main {

    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakeStrClientThread("ABC", activeObject).start();
        new MakeStrClientThread("DEF", activeObject).start();
        new DisplayStrThread("Display", activeObject).start();

    }
}
