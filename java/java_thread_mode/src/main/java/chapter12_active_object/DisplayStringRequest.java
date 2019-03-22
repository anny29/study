package chapter12_active_object;

/**
 * @program: DisplayStringRequest
 * @description: 展示字符串的请求
 * @author: lian.zh
 * @create: 2019-03-18 10:32
 */
class DisplayStringRequest extends MethodRequest {

    private Servant servant;

    private String str;

    public DisplayStringRequest(Servant servant, String str) {
        this.servant = servant;
        this.str = str;
    }

    @Override
    public void execute() {
        servant.display(str);
    }
}
