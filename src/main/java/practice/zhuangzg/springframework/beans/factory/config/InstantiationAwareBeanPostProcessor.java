package practice.zhuangzg.springframework.beans.factory.config;

import practice.zhuangzg.springframework.beans.BeansException;

/**
 * @author: ZhuangZG
 * @date 2022/7/6 16:54
 * @Description:
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
