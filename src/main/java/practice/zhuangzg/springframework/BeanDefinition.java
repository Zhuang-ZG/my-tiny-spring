package practice.zhuangzg.springframework;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:35
 * @Description:
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
