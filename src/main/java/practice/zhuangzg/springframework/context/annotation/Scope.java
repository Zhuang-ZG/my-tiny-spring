package practice.zhuangzg.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @author: ZhuangZG
 * @date 2022/7/12 6:05
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface Scope {

    String value() default "singleton";
}
