package practice.zhuangzg.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author: ZhuangZG
 * @date 2022/6/30 6:22
 * @Description:
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
