package practice.zhuangzg.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.PropertyValue;
import practice.zhuangzg.springframework.beans.factory.config.BeanDefinition;
import practice.zhuangzg.springframework.beans.factory.config.BeanReference;
import practice.zhuangzg.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import practice.zhuangzg.springframework.beans.factory.support.BeanDefinitionRegistry;
import practice.zhuangzg.springframework.core.io.Resource;
import practice.zhuangzg.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

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
        } catch (IOException | ClassNotFoundException e) {
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

    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }

            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }
            Element bean = (Element)childNodes.item(i);
            String name = bean.getAttribute("name");
            String id = bean.getAttribute("id");
            String className = bean.getAttribute("class");
            String initMethodName = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");

            Class<?> clazz = Class.forName(className);

            String beanName = StrUtil.isEmpty(name) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = clazz.getSimpleName();
            }
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethodName);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }
                if (! "property".equals(bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }

                Element attribute = (Element)bean.getChildNodes().item(j);
                String attrName = attribute.getAttribute("name");
                String attrValue = attribute.getAttribute("value");
                String attrRef = attribute.getAttribute("ref");
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
}
