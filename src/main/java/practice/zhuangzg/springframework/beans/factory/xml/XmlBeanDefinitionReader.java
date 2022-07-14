package practice.zhuangzg.springframework.beans.factory.xml;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.PropertyValue;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;
import practice.zhuangzg.springframework.beans.factory.config.BeanReference;
import practice.zhuangzg.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import practice.zhuangzg.springframework.beans.factory.support.BeanDefinitionRegistry;
import practice.zhuangzg.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import practice.zhuangzg.springframework.core.io.Resource;
import practice.zhuangzg.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * @author: ZhuangZG
 * @date 2022/6/20 10:38
 * @Description:
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException | DocumentException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            this.loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        Resource resource = getResourceLoader().getResource(location);
        this.loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location: locations) {
            loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        Element root = document.getRootElement();

        Element componentScan = root.element("component-scan");
        if (Objects.nonNull(componentScan)) {
            String scanPath = componentScan.attributeValue("base-package");
            if (StrUtil.isEmpty(scanPath)) {
                throw new BeansException("the value of base-package attribute con not be empty or null");
            }
            scanPackage(scanPath);
        }

        List<Element> beanList = root.elements("bean");
        for (Element bean : beanList) {

            String id = bean.attributeValue("id");
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");
            String initMethodName = bean.attributeValue("init-method");
            String destroyMethodName = bean.attributeValue("destroy-method");
            String beanScope = bean.attributeValue("scope");

            Class<?> clazz = Class.forName(className);

            String beanName = StrUtil.isEmpty(name) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethodName);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }


            List<Element> propertyList = bean.elements("property");
            for (Element property : propertyList) {

                String attrName = property.attributeValue("name");
                String attrValue = property.attributeValue("value");
                String attrRef = property.attributeValue("ref");

                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("duplicate beanName [" + beanName + " ] is not allowed");
            }
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

    private void scanPackage(String scanPath) {
        String[] basePackages = StrUtil.splitToArray(scanPath, CharUtil.COMMA);
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(getRegistry());
        scanner.doScan(basePackages);
    }
}
