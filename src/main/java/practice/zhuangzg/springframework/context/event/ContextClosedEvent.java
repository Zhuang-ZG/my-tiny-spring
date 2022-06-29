package practice.zhuangzg.springframework.context.event;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 13:00
 * @Description:
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }



}
