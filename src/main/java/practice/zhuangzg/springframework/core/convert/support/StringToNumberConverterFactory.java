package practice.zhuangzg.springframework.core.convert.support;

import cn.hutool.core.util.NumberUtil;
import practice.zhuangzg.springframework.core.convert.converter.Converter;
import practice.zhuangzg.springframework.core.convert.converter.ConverterFactory;
import practice.zhuangzg.springframework.util.NumberUtils;

/**
 * @author: ZhuangZG
 * @date 2022/7/21 18:37
 * @Description:
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T > {
        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            if ((source.isEmpty())) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }
}
