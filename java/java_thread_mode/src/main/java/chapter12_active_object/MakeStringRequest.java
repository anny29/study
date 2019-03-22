package chapter12_active_object;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: MakeStringRequest
 * @description: 生成字符串的请求类
 * @author: lian.zh
 * @create: 2019-03-15 11:22
 */
@Slf4j
class MakeStringRequest extends MethodRequest {

    private Servant servant;

    private int count;

    private char c;

    private FutureResult<String> futureResult;

    public MakeStringRequest(Servant servant, int count, char c, FutureResult<String> futureResult) {
        this.servant = servant;
        this.count = count;
        this.c = c;
        this.futureResult = futureResult;
    }

    @Override
    public void execute() {
        Result<String> realResult = servant.makeString(count, c);
//        log.info("Make String: {}", realResult.getResult());
        futureResult.setResult((ConcreteResult) realResult);
    }
}
