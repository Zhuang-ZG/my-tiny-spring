package practice.zhuangzg.springframework.aop.aspectj;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import practice.zhuangzg.springframework.aop.ClassFilter;
import practice.zhuangzg.springframework.aop.MethodMatcher;
import practice.zhuangzg.springframework.aop.PointCut;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: ZhuangZG
 * @date 2022/6/30 6:37
 * @Description:
 */
public class AspectJExpressionPointcut implements PointCut, ClassFilter, MethodMatcher {

    private final static Set<PointcutPrimitive>  SUPPORT_PRIMITIVE = new HashSet<>();

    static {
        SUPPORT_PRIMITIVE.add(PointcutPrimitive.EXECUTION);
    }

    private final PointcutExpression pointcutExpression;

    public AspectJExpressionPointcut(String expression) {
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORT_PRIMITIVE, this.getClass().getClassLoader());
        this.pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }

    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
