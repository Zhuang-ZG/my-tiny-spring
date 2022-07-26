package practice.zhuangzg.springframework.core.convert.support;

import practice.zhuangzg.springframework.core.convert.converter.ConverterRegistry;

/**
 * @author: ZhuangZG
 * @date 2022/7/21 18:22
 * @Description:
 */
public class DefaultConversionService extends GenericConversionService{

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
