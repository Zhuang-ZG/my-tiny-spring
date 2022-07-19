package practice.zhuangzg.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author: ZhuangZG
 * @date 2022/7/14 22:34
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";

}
