package practice.zhuangzg.springframework.aop.framework;

import practice.zhuangzg.springframework.aop.AdvisedSupport;

/**
 * @author: ZhuangZG
 * @date 2022/7/6 16:44
 * @Description:
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }
}
