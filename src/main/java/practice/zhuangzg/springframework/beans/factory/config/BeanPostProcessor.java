package practice.zhuangzg.springframework.beans.factory.config;

import practice.zhuangzg.springframework.beans.BeansException;

import javax.management.MBeanServerNotification;
import java.util.Objects;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 21:32
 * @Description:
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
