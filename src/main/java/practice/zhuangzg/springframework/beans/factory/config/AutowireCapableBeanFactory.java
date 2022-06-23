package practice.zhuangzg.springframework.beans.factory.config;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.BeanFactory;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 6:24
 * @Description:
 */
public interface AutowireCapableBeanFactory extends BeanFactory {


    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;


    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
