package practice.zhuangzg.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;
import practice.zhuangzg.springframework.context.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: ZhuangZG
 * @date 2022/7/12 6:10
 * @Description:
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponent(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
