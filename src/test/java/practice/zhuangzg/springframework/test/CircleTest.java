package practice.zhuangzg.springframework.test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhuangZG
 * @date 2022/7/20 16:05
 * @Description:
 */
public class CircleTest {

    public static final Map<String, Object> singletonObjects = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.out.println(getBean(B.class).getA());
        System.out.println(getBean(A.class).getB());
    }

    public static <T> T getBean(Class<T> beanClass) throws Exception {
        String beanName = beanClass.getSimpleName().toLowerCase();
        if (singletonObjects.containsKey(beanName)) {
            return (T)singletonObjects.get(beanName);
        }

        Object obj = beanClass.newInstance();
        singletonObjects.put(beanName, obj);

        Field[] fields = beanClass.getDeclaredFields();
        Arrays.stream(fields).forEach(f -> {
            f.setAccessible(true);
            Class<?> fieldType = f.getType();
            String fieldName = fieldType.getSimpleName().toLowerCase();
            try {
                f.set(obj, singletonObjects.containsKey(fieldName) ? singletonObjects.get(fieldName) : getBean(fieldType));
            } catch (Exception e) {
                e.printStackTrace();
            }
            f.setAccessible(false);
        });
        return (T)obj;
    }

}

class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
