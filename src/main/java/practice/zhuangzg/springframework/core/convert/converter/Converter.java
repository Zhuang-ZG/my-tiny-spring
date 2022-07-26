package practice.zhuangzg.springframework.core.convert.converter;

/**
 * @author: ZhuangZG
 * @date 2022/7/21 8:04
 * @Description:
 */
public interface Converter<S, T> {

    T convert(S source);

}
