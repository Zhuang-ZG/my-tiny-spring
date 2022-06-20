package practice.zhuangzg.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhuangZG
 * @date 2022/6/17 16:53
 * @Description:
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String name) {
        return propertyValues.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst().orElse(null);
    }
}
