package practice.zhuangzg.springframework.test.event;

import practice.zhuangzg.springframework.context.ApplicationEvent;
import practice.zhuangzg.springframework.context.event.ApplicationContextEvent;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 22:26
 * @Description:
 */
public class CustomEvent extends ApplicationContextEvent {

    private Long id;
    private String message;

    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
