package practice.zhuangzg.springframework.context.support;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.ConfigurableListableBeanFactory;
import practice.zhuangzg.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 22:16
 * @Description:
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() throws BeansException {
        return beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

}
