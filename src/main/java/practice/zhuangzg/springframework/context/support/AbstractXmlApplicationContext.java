package practice.zhuangzg.springframework.context.support;

import practice.zhuangzg.springframework.beans.factory.support.DefaultListableBeanFactory;
import practice.zhuangzg.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Objects;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 22:21
 * @Description:
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (Objects.nonNull(configLocations)) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
