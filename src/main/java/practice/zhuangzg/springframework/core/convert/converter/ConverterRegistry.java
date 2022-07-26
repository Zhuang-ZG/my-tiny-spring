package practice.zhuangzg.springframework.core.convert.converter;

/**
 * @author: ZhuangZG
 * @date 2022/7/21 8:06
 * @Description:
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverter(GenericConverter converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);
}
