package practice.zhuangzg.springframework.core.convert;

import com.sun.istack.internal.Nullable;

/**
 * @author: ZhuangZG
 * @date 2022/7/21 18:00
 * @Description:
 */
public interface ConversionService {

    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<?> targetType);
}
