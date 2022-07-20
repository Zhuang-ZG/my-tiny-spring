package practice.zhuangzg.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.DisposableBean;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author: ZhuangZG
 * @date 2022/6/24 11:06
 * @Description:
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }


    @Override
    public void destroy() throws Exception {
        // 针对实现DisposableBean接口的方式
        if (this.bean instanceof DisposableBean) {
            ((DisposableBean)bean).destroy();
        }

        // 针对通过xml文件配置destroy-method的方式 {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(this.destroyMethodName) &&
            !(this.bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))
        ) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (Objects.isNull(destroyMethod)) {
                throw new BeansException("could not find a destroy method named '" +
                destroyMethodName +"' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
