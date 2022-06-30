package practice.zhuangzg.springframework.test.bean;

import java.util.Random;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:42
 * @Description:
 */
public class UserService implements IUserService {

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AAA";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success !";
    }
}
