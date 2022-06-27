package practice.zhuangzg.springframework.util;

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
}
