package practice.zhuangzg.springframework.test;

import org.junit.jupiter.api.Test;
import practice.zhuangzg.springframework.aop.AdvisedSupport;
import practice.zhuangzg.springframework.aop.TargetSource;
import practice.zhuangzg.springframework.aop.aspectj.AspectJExpressionPointcut;
import practice.zhuangzg.springframework.aop.framework.Cglib2AopProxy;
import practice.zhuangzg.springframework.aop.framework.JdkDynamicAopProxy;
import practice.zhuangzg.springframework.context.support.ClassPathXmlApplicationContext;
import practice.zhuangzg.springframework.test.bean.IUserService;
import practice.zhuangzg.springframework.test.bean.UserService;
import practice.zhuangzg.springframework.test.bean.UserServiceInterceptor;
import practice.zhuangzg.springframework.test.event.CustomEvent;

/**
 * @author: ZhuangZG
 * @date 2022/6/13 8:50
 * @Description:
 */
public class ApiTest {

    @Test
    public void test() {
/*
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
*/

    }

    @Test
    public void testXml() {
/*        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
        System.out.println(userService.toString());

        System.out.println("applicationContextAware: " + userService.getApplicationContext());
        System.out.println("beanFactory: " + userService.getBeanFactory());*/
    }

    @Test
    public void testProtocol() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService01);
        System.out.println(userService02);

        System.out.println(userService01 + "十六进制哈希值：" + Integer.toHexString(userService01.hashCode()));

    }

    @Test
    public void testFactoryBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }

    @Test
    public void testEvent() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 100L, "customEvent成功了"));

        applicationContext.registerShutdownHook();

    }

    @Test
    public void testDynamic() {

        IUserService userService = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* practice.zhuangzg.springframework.test.bean.IUserService.*(..))"));

        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_cglib.register("花花"));

    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.register("AAA"));
    }
}
