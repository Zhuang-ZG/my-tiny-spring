package practice.zhuangzg.springframework.beans.factory.config;

/**
 * @author: ZhuangZG
 * @date 2022/6/17 17:10
 * @Description:
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
