package practice.zhuangzg.springframework.core.convert.converter;

/**
 * @author: ZhuangZG
 * @date 2022/7/21 8:05
 * @Description:
 */
public interface ConverterFactory<S, R> {

    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
