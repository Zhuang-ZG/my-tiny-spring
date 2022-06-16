package practice.zhuangzg.springframework.beans.factory.support;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.BeanFactory;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.Objects;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 22:51
 * @Description:
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (Objects.nonNull(bean)) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String beanName);


}
