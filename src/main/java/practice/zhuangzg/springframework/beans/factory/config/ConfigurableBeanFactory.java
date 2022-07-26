package practice.zhuangzg.springframework.beans.factory.config;

import practice.zhuangzg.springframework.beans.factory.HierarchicalBeanFactory;
import practice.zhuangzg.springframework.core.convert.ConversionService;
import practice.zhuangzg.springframework.util.StringValueResolver;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 6:25
 * @Description:
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueSolver);

    String resolveEmbeddedValue(String value);

    ConversionService getConversionService();

    void setConversionService(ConversionService conversionService);


}
