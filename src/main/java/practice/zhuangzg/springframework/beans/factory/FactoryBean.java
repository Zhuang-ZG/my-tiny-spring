package practice.zhuangzg.springframework.beans.factory;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 6:22
 * @Description:
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}
