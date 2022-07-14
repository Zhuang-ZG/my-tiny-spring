package practice.zhuangzg.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;
import practice.zhuangzg.springframework.beans.factory.support.BeanDefinitionRegistry;
import practice.zhuangzg.springframework.context.stereotype.Component;

import java.util.Objects;
import java.util.Set;

/**
 * @author: ZhuangZG
 * @date 2022/7/12 6:11
 * @Description:
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponent(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                String beanScope = this.resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (Objects.nonNull(scope)) {
            return scope.value();
        }
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (Objects.nonNull(value)) {
            return component.value();
        }
        return StrUtil.EMPTY;
    }
}
