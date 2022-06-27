package practice.zhuangzg.springframework.test;

import org.junit.jupiter.api.Test;
import practice.zhuangzg.springframework.beans.factory.support.DefaultListableBeanFactory;
import practice.zhuangzg.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import practice.zhuangzg.springframework.context.support.ClassPathXmlApplicationContext;
import practice.zhuangzg.springframework.test.bean.UserService;
import practice.zhuangzg.springframework.test.common.MyBeanFactoryPostProcessor;
import practice.zhuangzg.springframework.test.common.MyBeanPostProcessor;

/**
 * @author: ZhuangZG
 * @date 2022/6/13 8:50
 * @Description:
 */
public class ApiTest {

    @Test
    public void test() {
        // 1 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2 创建BeanDefinition加载器，加载BeanDefinition
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 3 创建BeanFactoryPostProcessor对BeanDefinition进行修改
        MyBeanFactoryPostProcessor myBeanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        myBeanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4 Bean实例化之后，修改Bean实例的信息
        MyBeanPostProcessor myBeanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(myBeanPostProcessor);

        // 5 获得创建好的Bean实例
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        System.out.println(userService.toString());

    }

    @Test
    public void testXml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
        System.out.println(userService.toString());
    }
}
