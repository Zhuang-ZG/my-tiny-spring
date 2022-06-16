package practice.zhuangzg.springframework.beans.factory.config;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:35
 * @Description:
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
