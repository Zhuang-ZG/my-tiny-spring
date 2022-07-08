package practice.zhuangzg.springframework.aop;

/**
 * @author: ZhuangZG
 * @date 2022/7/6 16:33
 * @Description:
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
