package chapter1_single_thread_execution.deadlock;

/**
 * @program: Tool
 * @description: 餐具类
 * @author: lian.zh
 * @create: 2018-11-23 09:47
 */
public class Tool {
    private String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ " + name + " ]";
    }
}
