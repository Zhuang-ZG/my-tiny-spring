package practice.zhuangzg.springframework.beans.factory.config;

import practice.zhuangzg.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 6:25
 * @Description:
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
