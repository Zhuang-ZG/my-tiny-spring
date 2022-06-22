package practice.zhuangzg.springframework.beans.factory.support;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.BeanFactory;
import practice.zhuangzg.springframework.beans.factory.ConfigurableListableBeanFactory;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 22:57
 * @Description:
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (Objects.isNull(beanDefinition)) {
            throw new BeansException("no bean named " + beanName + " is defined");
        }
        return beanDefinition;
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (beanClass.isAssignableFrom(type)) {
                result.put(beanName, (T)getBean(beanName));
            }
        });
        return result;
    }
}
