package practice.zhuangzg.springframework.test;

import org.junit.jupiter.api.Test;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;
import practice.zhuangzg.springframework.beans.factory.support.DefaultListableBeanFactory;
import practice.zhuangzg.springframework.test.bean.UserService;

/**
 * @author: ZhuangZG
 * @date 2022/6/13 8:50
 * @Description:
 */
public class ApiTest {

    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
