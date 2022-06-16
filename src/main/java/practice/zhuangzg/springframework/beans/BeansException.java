package practice.zhuangzg.springframework.beans;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 22:45
 * @Description:
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
