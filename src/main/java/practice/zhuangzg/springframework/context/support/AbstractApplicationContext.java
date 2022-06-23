package practice.zhuangzg.springframework.context.support;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.ConfigurableListableBeanFactory;
import practice.zhuangzg.springframework.beans.factory.config.BeanFactoryPostProcessor;
import practice.zhuangzg.springframework.beans.factory.config.BeanPostProcessor;
import practice.zhuangzg.springframework.context.ConfigurableApplicationContext;
import practice.zhuangzg.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 21:43
 * @Description:
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {

        // 1 创建BeanFactory，并注册BeanDefinitions
        refreshBeanFactory();

        // 2 获得BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3 在Bean实例化之前，调用invokeBeanFactoryPostProcessor 修改BeanDefinition信息
        invokeBeanFactoryPostProcessor(beanFactory);

        // 4 在Bean实例化之前，注册BeanPostProcessor
        registerBeanPostProcessors(beanFactory);

        // 5 提前实例化单例Bean
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory() throws BeansException;

    private void invokeBeanFactoryPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor: beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }


    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
