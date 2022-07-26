package practice.zhuangzg.springframework.context.support;

import com.sun.istack.internal.Nullable;
import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.FactoryBean;
import practice.zhuangzg.springframework.beans.factory.InitializingBean;
import practice.zhuangzg.springframework.core.convert.ConversionService;
import practice.zhuangzg.springframework.core.convert.converter.Converter;
import practice.zhuangzg.springframework.core.convert.converter.ConverterFactory;
import practice.zhuangzg.springframework.core.convert.converter.ConverterRegistry;
import practice.zhuangzg.springframework.core.convert.converter.GenericConverter;
import practice.zhuangzg.springframework.core.convert.support.DefaultConversionService;
import practice.zhuangzg.springframework.core.convert.support.GenericConversionService;

import java.util.Objects;
import java.util.Set;

/**
 * @author: ZhuangZG
 * @date 2022/7/26 9:27
 * @Description:
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    @Nullable
    private Set<?> converters;

    @Nullable
    private GenericConversionService conversionService;

    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public Class<?> getObjectType() {
        return conversionService.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);
    }

    private void registerConverters(Set<?> converters, ConverterRegistry registry) {
        if (Objects.nonNull(registry)) {
            for (Object converter : converters) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converter instanceof Converter<?, ?>) {
                    registry.addConverter((Converter<?, ?>) converter);
                } else if (converter instanceof ConverterFactory<?,?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter must implement on of the " +
                            "Converter, ConverterFactory or GenericConverter interface");
                }
            }
        }
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }
}
