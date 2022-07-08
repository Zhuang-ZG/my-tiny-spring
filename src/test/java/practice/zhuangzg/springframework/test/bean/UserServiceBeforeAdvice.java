package practice.zhuangzg.springframework.test.bean;

import practice.zhuangzg.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: ZhuangZG
 * @date 2022/7/6 17:13
 * @Description:
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法");
    }
}
