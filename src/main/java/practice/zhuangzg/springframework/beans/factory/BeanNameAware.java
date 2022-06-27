package practice.zhuangzg.springframework.beans.factory;

import practice.zhuangzg.springframework.beans.BeansException;

/**
 * @author: ZhuangZG
 * @date 2022/6/27 12:58
 * @Description:
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String beanName) throws BeansException;
}
