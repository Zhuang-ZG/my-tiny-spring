package practice.zhuangzg.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author: ZhuangZG
 * @date 2022/6/30 6:21
 * @Description:
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
