package practice.zhuangzg.springframework.context;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 17:18
 * @Description:
 */
public interface ApplicationEventPublisher {

    /**
     * publish specified event
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
