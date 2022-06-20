package practice.zhuangzg.springframework.test;

import org.junit.jupiter.api.Test;
import practice.zhuangzg.springframework.beans.PropertyValue;
import practice.zhuangzg.springframework.beans.PropertyValues;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;
import practice.zhuangzg.springframework.beans.factory.config.BeanReference;
import practice.zhuangzg.springframework.beans.factory.support.DefaultListableBeanFactory;
import practice.zhuangzg.springframework.test.bean.UserDao;
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
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class);
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", 10002));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        userServiceBeanDefinition.setPropertyValues(propertyValues);
        beanFactory.registerBeanDefinition("userService", userServiceBeanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
