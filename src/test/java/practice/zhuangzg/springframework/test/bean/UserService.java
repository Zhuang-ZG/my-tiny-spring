package practice.zhuangzg.springframework.test.bean;

import javax.jws.soap.SOAPBinding;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:42
 * @Description:
 */
public class UserService {

    private String uid;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String uid, UserDao userDao) {
        this.uid = uid;
        this.userDao = userDao;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息: " + userDao.queryUserName(uid));
    }
}
