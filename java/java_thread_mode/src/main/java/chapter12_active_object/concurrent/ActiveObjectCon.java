package chapter12_active_object.concurrent;

import java.util.concurrent.Future;

/**
 * @program: ActiveObjectCon
 * @description: 使用future接口的主动对象接口
 * @author: lian.zh
 * @create: 2019-03-19 10:22
 */
public interface ActiveObjectCon {

    public Future<String> makeString(char c, int count);

    public void displayString(String msg);
}
