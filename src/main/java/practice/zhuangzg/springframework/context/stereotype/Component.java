package practice.zhuangzg.springframework.context.stereotype;

import java.lang.annotation.*;


/**
 * @author: ZhuangZG
 * @date 2022/7/12 6:07
 * @Description:
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Component {

    String value() default "";

}
