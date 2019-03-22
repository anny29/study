package chapter12_active_object;

/**
 * @program: DisplayStrThread
 * @description: 发出显示字符串的请求
 * @author: lian.zh
 * @create: 2019-03-18 15:23
 */
public class DisplayStrThread extends Thread {
    private ActiveObject activeObject;

    public DisplayStrThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 99; i++) {
            activeObject.display("Display Msg: " + i);
        }
    }
}
