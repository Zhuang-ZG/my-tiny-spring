package practice.zhuangzg.springframework.test.converter;

import practice.zhuangzg.springframework.core.convert.converter.Converter;

/**
 * @author: ZhuangZG
 * @date 2022/7/26 10:09
 * @Description:
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }
}
