package practice.zhuangzg.springframework.context;

import practice.zhuangzg.springframework.beans.BeansException;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 21:33
 * @Description:
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
