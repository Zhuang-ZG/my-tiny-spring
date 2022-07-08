package practice.zhuangzg.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import practice.zhuangzg.springframework.aop.MethodBeforeAdvice;

/**
 * @author: ZhuangZG
 * @date 2022/7/6 16:39
 * @Description:
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.advice.before(methodInvocation.getMethod(), methodInvocation.getArguments(),
                methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
