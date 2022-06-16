package practice.zhuangzg.springframework.beans.factory.support;

import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;

/**
 * @author: ZhuangZG
 * @date 2022/6/17 6:00
 * @Description:
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
