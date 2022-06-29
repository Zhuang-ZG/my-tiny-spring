package practice.zhuangzg.springframework.context.event;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 13:01
 * @Description:
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
