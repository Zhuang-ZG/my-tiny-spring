package practice.zhuangzg.springframework.beans.factory;

import practice.zhuangzg.springframework.beans.BeansException;

/**
 * @author: ZhuangZG
 * @date 2022/7/20 11:29
 * @Description:
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}
