package practice.zhuangzg.springframework.context;

import java.util.EventListener;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 13:03
 * @Description:
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {


    void onApplicationEvent(E event);
}
