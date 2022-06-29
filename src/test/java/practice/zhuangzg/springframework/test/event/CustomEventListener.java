package practice.zhuangzg.springframework.test.event;

import practice.zhuangzg.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 22:28
 * @Description:
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到: " + event.getSource() + "消息， 时间是" + new Date());
        System.out.println("消息内容: " + event.getId() + ": " + event.getMessage());
    }
}
