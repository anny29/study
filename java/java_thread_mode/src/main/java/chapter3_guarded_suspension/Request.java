package chapter3_guarded_suspension;

/**
 * @program: Request
 * @description: 模拟请求类
 * @author: lian.zh
 * @create: 2019-01-04 15:25
 */
public class Request {
    private final String name;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}
