package practice.zhuangzg.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author: ZhuangZG
 * @date 2022/7/14 22:36
 * @Description:
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    String value();
}
