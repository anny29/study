package chapter3_guarded_suspension.exercise;

/**
 * @program: LivenessException
 * @description: 生存性异常
 * @author: lian.zh
 * @create: 2019-01-09 09:41
 */
public class LivenessException extends RuntimeException {

    public LivenessException(String message) {
        super(message);
    }
}
