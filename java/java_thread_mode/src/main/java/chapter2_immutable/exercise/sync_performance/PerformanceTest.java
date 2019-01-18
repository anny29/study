package chapter2_immutable.exercise.sync_performance;

/**
 * @program: PerformanceTest
 * @description: 同步非同步类性能测试
 * @author: lian.zh
 * @create: 2019-01-02 10:05
 */
public class PerformanceTest {

    private static final long COUNT = 100000000L;

    public static void main(String[] args) {
        trial("NotSync", COUNT, new NotSync());
        trial("Sync", COUNT, new Sync());
    }

    public static void trial(String testNm, long count, Object object) {
        System.out.println(testNm + " Begin!");
        long start = System.currentTimeMillis();
        long i = 0;
        while (i < count) {
            object.toString();
            i++;
        }
        System.out.println(testNm + " End! 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    }
}
