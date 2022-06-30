package practice.zhuangzg.springframework.aop;

/**
 * @author: ZhuangZG
 * @date 2022/6/30 6:46
 * @Description:
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
