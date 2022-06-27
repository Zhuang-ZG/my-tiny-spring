package practice.zhuangzg.springframework.beans.factory.support;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 6:24
 * @Description:
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (Objects.isNull(object)) {
                object = doGetBeanFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, Objects.nonNull(object) ? object : NULL_OBJECT);
            }
            return (object != NULL_OBJECT ? object : null);
        } else {
            return doGetBeanFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetBeanFromFactoryBean(final FactoryBean factory, final String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("factoryBean threw exception on bean '" + beanName + "' creation", e);
        }
    }
}
