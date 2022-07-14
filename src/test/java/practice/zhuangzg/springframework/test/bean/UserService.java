package practice.zhuangzg.springframework.test.bean;

import practice.zhuangzg.springframework.context.stereotype.Component;

import java.util.Random;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:42
 * @Description:
 */
@Component("userService")
public class UserService implements IUserService {

    private String token;

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

    @Override
    public String toString() {
        return "UserService{" +
                "token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
