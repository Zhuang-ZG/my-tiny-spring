package practice.zhuangzg.springframework.aop;

import practice.zhuangzg.springframework.util.ClassUtils;

/**
 * @author: ZhuangZG
 * @date 2022/6/30 6:46
 * @Description:
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
