package chapter12_active_object;

/**
 * @program: ConcreteResult
 * @description: 真实的处理结果
 * @author: lian.zh
 * @create: 2019-03-18 09:58
 */
class ConcreteResult<T> implements Result<T> {

    private T result;

    public ConcreteResult(T result) {
        this.result = result;
    }

    @Override
    public T getResult() {
        return result;
    }
}
