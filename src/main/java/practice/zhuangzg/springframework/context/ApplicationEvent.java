package practice.zhuangzg.springframework.context;

import java.util.EventObject;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 12:57
 * @Description:
 */
public abstract class ApplicationEvent extends EventObject {


    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
