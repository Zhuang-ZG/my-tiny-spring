package practice.zhuangzg.springframework.test.bean;

import practice.zhuangzg.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: ZhuangZG
 * @date 2022/7/20 14:28
 * @Description:
 */
public class SpouseAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("关怀夫妻(切面)：" + method);
    }

}
