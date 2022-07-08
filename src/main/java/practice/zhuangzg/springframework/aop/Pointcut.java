package practice.zhuangzg.springframework.aop;

/**
 * @author: ZhuangZG
 * @date 2022/6/30 6:21
 * @Description:
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
