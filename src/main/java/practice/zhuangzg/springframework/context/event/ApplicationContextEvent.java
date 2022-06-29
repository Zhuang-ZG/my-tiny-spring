package practice.zhuangzg.springframework.context.event;

import practice.zhuangzg.springframework.context.ApplicationContext;
import practice.zhuangzg.springframework.context.ApplicationEvent;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 12:58
 * @Description:
 */
public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
