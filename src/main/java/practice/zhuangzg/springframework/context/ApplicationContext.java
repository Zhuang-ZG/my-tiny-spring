package practice.zhuangzg.springframework.context;

import practice.zhuangzg.springframework.beans.factory.HierarchicalBeanFactory;
import practice.zhuangzg.springframework.beans.factory.ListableBeanFactory;
import practice.zhuangzg.springframework.core.io.ResourceLoader;

/**
 * @author: ZhuangZG
 * @date 2022/6/22 21:33
 * @Description:
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
