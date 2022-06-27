package practice.zhuangzg.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhuangZG
 * @date 2022/6/17 17:30
 * @Description:
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行init方法");
        hashMap.put("10001", "AAA");
        hashMap.put("10002", "BBB");
        hashMap.put("10003", "CCC");
    }

    public void destroyDataMethod() {
        System.out.println("执行destroy方法");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }


    @Override
    public String toString() {
        return "UserDao{}";
    }
}
