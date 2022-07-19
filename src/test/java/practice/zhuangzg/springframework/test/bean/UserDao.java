package practice.zhuangzg.springframework.test.bean;

import practice.zhuangzg.springframework.context.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhuangZG
 * @date 2022/7/15 6:21
 * @Description:
 */
@Component
public class UserDao {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("1001", "AAA");
        map.put("1002", "BBB");
        map.put("1003", "CCC");
    }

    public String queryUserName(String uId) {
        return map.get(uId);
    }
}
