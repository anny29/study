package aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @program: TimeCostAspect
 * @description: 记录耗时切面
 * @author: lian.zh
 * @create: 2019-02-11 17:11
 */
@Slf4j
@Component
@Aspect
public class TimeCostAspect {

    @Around("@annotation(annotation.TimeCost)")
    public Object timeCost(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("方法：{} 耗时：{}", joinPoint.getSignature().toString(), stopWatch.toString());
        }
    }
}
