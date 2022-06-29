package practice.zhuangzg.springframework.test.event;

import practice.zhuangzg.springframework.context.ApplicationListener;
import practice.zhuangzg.springframework.context.event.ApplicationContextEvent;
import practice.zhuangzg.springframework.context.event.ContextClosedEvent;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 22:32
 * @Description:
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
