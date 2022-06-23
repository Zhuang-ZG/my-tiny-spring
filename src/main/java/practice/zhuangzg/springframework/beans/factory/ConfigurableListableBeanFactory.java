package practice.zhuangzg.springframework.beans.factory;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.config.AutowireCapableBeanFactory;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;
import practice.zhuangzg.springframework.beans.factory.config.BeanPostProcessor;
import practice.zhuangzg.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 6:32
 * @Description:
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
