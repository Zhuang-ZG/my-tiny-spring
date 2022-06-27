package practice.zhuangzg.springframework.beans.factory;

import practice.zhuangzg.springframework.beans.BeansException;

/**
 * @author: ZhuangZG
 * @date 2022/6/27 12:59
 * @Description:
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;
}
