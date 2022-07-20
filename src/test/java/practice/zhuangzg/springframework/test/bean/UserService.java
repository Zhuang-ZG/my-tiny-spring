package practice.zhuangzg.springframework.test.bean;

import practice.zhuangzg.springframework.beans.factory.annotation.Autowired;
import practice.zhuangzg.springframework.beans.factory.annotation.Value;
import practice.zhuangzg.springframework.context.stereotype.Component;

import java.util.Random;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:42
 * @Description:
 */
public class UserService implements IUserService {

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "AAA，" + token;
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
