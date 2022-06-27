package practice.zhuangzg.springframework.test.bean;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.*;
import practice.zhuangzg.springframework.context.ApplicationContext;
import practice.zhuangzg.springframework.context.ApplicationContextAware;

import javax.jws.soap.SOAPBinding;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:42
 * @Description:
 */
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String uid;
    private String company;
    private String location;
    private UserDao userDao;

    public UserService() {
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) throws BeansException {
        System.out.println("classloader: " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) throws BeansException {
        System.out.println("bean name is " + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息: " + userDao.queryUserName(uid));
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uid='" + uid + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", userDao=" + userDao +
                '}';
    }
}
