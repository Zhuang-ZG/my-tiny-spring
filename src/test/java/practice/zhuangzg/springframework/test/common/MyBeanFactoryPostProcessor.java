package practice.zhuangzg.springframework.test.common;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.PropertyValue;
import practice.zhuangzg.springframework.beans.PropertyValues;
import practice.zhuangzg.springframework.beans.factory.ConfigurableListableBeanFactory;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;
import practice.zhuangzg.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author: ZhuangZG
 * @date 2022/6/23 6:56
 * @Description:
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "CMB"));
    }
}
