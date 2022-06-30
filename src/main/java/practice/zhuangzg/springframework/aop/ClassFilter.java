package practice.zhuangzg.springframework.aop;

/**
 * @author: ZhuangZG
 * @date 2022/6/30 6:22
 * @Description:
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
