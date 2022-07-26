package practice.zhuangzg.springframework.core.convert.converter;

import cn.hutool.core.lang.Assert;

import java.util.Objects;
import java.util.Set;

/**
 * @author: ZhuangZG
 * @date 2022/7/21 18:00
 * @Description:
 */
public interface GenericConverter {

    Set<ConvertiblePair> getConvertibleTypes();

    Object convert(Object source, Class<?> sourceClass, Class<?> targetClass);

    final class ConvertiblePair {
        private final Class<?> sourceType;

        private final Class<?> targetType;

        public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
            Assert.notNull(sourceType, "Source type must not be null");
            Assert.notNull(targetType, "Target type must not be null");
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        public Class<?> getSourceType() {
            return sourceType;
        }

        public Class<?> getTargetType() {
            return targetType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (Objects.isNull(o) || ConvertiblePair.class != o.getClass()) {
                return false;
            }
            ConvertiblePair that = (ConvertiblePair) o;
            return sourceType.equals(that.sourceType) && targetType.equals(that.targetType);
        }

        @Override
        public int hashCode() {
            return this.sourceType.hashCode() * 31 + this.targetType.hashCode();
        }
    }
}
