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
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    private <T> T doGetBean(String beanName, Object[] args) {
        Object singleton = getSingleton(beanName);
        if (Objects.nonNull(singleton)) {
            return (T)singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T)createBean(beanName, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


}
