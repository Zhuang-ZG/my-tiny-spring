package practice.zhuangzg.springframework.aop;


import java.lang.reflect.Method;

/**
 * @author: ZhuangZG
 * @date 2022/7/6 16:31
 * @Description:
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
