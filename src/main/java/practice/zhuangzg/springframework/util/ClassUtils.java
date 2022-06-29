package practice.zhuangzg.springframework.util;

import cn.hutool.core.util.StrUtil;

import java.util.Objects;

/**
 * @author: ZhuangZG
 * @date 2022/6/20 9:45
 * @Description:
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {

        }
        if (Objects.isNull(classLoader)) {
            classLoader =ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }

    /**
     * check whether the specified class is a CGLIB-generated class
     * @param clazz
     * @return
     */
    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (Objects.nonNull(clazz) && isCglibProxyClassName(clazz.getName()));
    }

    /**
     * check whether the specified class name belongs to a CGLIB-generated class
     * @param className
     * @return
     */
    public static boolean isCglibProxyClassName(String className) {
        return (StrUtil.isNotEmpty(className) && className.contains("$$"));
    }
}
