package practice.zhuangzg.springframework.test.event;

import practice.zhuangzg.springframework.context.ApplicationListener;
import practice.zhuangzg.springframework.context.event.ContextRefreshedEvent;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 22:34
 * @Description:
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + event.getClass().getName());
    }
}
