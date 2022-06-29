package practice.zhuangzg.springframework.context.event;

import practice.zhuangzg.springframework.context.ApplicationEvent;
import practice.zhuangzg.springframework.context.ApplicationListener;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 13:06
 * @Description:
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);


}
