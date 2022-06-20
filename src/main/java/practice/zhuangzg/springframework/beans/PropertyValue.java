package practice.zhuangzg.springframework.beans;

/**
 * @author: ZhuangZG
 * @date 2022/6/17 16:52
 * @Description:
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
