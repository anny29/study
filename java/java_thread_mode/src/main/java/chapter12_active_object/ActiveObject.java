package chapter12_active_object;

/**
 * @program: ActiveObject
 * @description: 主动对象接口
 * @author: lian.zh
 * @create: 2019-03-15 10:46
 */
public interface ActiveObject {

    public Result<String> makeString(int i, char c);

    public void display(String msg);

}
