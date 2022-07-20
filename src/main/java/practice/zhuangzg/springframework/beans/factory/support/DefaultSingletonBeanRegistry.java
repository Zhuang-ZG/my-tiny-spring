package practice.zhuangzg.springframework.beans.factory.support;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.DisposableBean;
import practice.zhuangzg.springframework.beans.factory.ObjectFactory;
import practice.zhuangzg.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 22:48
 * @Description:
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected final static Object NULL_OBJECT = new Object();

    // 一级缓存，已创建好的对象
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 二级缓存，提前暴露对象，没有完全实例化的对象
    private Map<String, Object> earlySingletonObjects = new HashMap<>();

    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>();


    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (Objects.isNull(singletonObject)) {
            singletonObject = earlySingletonObjects.get(beanName);
            // 判断二级缓存中是否有对象，这个对象就是代理对象，因为只有代理对象才会放到三级缓存中
            if (Objects.isNull(singletonObject)) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (Objects.nonNull(singletonFactory)) {
                    singletonObject = singletonFactory.getObject();
                    // 把三级缓存中的代理对象中的真实对象获取出来，放入二级缓存中
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory){
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        this.disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object disposableBeanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(disposableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("destroy method on bean with name '" +
                        disposableBeanName + "' throw an exception");
            }
        }
    }
}
