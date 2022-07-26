package practice.zhuangzg.springframework.test;

import org.junit.jupiter.api.Test;
import practice.zhuangzg.springframework.context.support.ClassPathXmlApplicationContext;
import practice.zhuangzg.springframework.core.convert.converter.Converter;
import practice.zhuangzg.springframework.core.convert.support.StringToNumberConverterFactory;
import practice.zhuangzg.springframework.test.bean.Husband;
import practice.zhuangzg.springframework.test.converter.StringToIntegerConverter;
import practice.zhuangzg.springframework.test.converter.StringToLocalDateConverter;

/**
 * @author: ZhuangZG
 * @date 2022/6/13 8:50
 * @Description:
 */
public class ApiTest {

    @Test
    public void test_convert() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println(husband.toString());
    }

    @Test
    public void test_StringToIntegerConverter() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer num = converter.convert("1234");
        System.out.println("测试结果：" + num);
    }

    @Test
    public void test_StringToNumberConverterFactory() {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();

        Converter<String, Integer> stringToIntegerConverter = converterFactory.getConverter(Integer.class);
        System.out.println("测试结果：" + stringToIntegerConverter.convert("1234"));

        Converter<String, Long> stringToLongConverter = converterFactory.getConverter(Long.class);
        System.out.println("测试结果：" + stringToLongConverter.convert("1234"));
    }

}
