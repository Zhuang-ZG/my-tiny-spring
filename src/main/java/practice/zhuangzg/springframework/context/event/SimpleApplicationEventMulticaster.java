package practice.zhuangzg.springframework.context.event;

import practice.zhuangzg.springframework.beans.factory.BeanFactory;
import practice.zhuangzg.springframework.context.ApplicationEvent;
import practice.zhuangzg.springframework.context.ApplicationListener;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 22:07
 * @Description:
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
