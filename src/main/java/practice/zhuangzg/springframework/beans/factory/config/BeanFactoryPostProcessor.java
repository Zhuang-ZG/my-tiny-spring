package practice.zhuangzg.springframework.beans.factory.config;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 21:32
 * @Description:
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException;

}
