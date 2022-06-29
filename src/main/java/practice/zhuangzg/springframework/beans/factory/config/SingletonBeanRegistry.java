package practice.zhuangzg.springframework.beans.factory.config;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 22:47
 * @Description:
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
