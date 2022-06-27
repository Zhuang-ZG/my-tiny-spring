package practice.zhuangzg.springframework.beans.factory;

import practice.zhuangzg.springframework.beans.BeansException;

import java.beans.Beans;

/**
 * @author: ZhuangZG
 * @date 2022/6/27 12:57
 * @Description:
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
