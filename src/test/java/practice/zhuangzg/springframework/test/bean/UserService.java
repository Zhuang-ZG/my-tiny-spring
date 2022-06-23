package practice.zhuangzg.springframework.test.bean;

import javax.jws.soap.SOAPBinding;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:42
 * @Description:
 */
public class UserService {

    private String uid;
    private String company;
    private String location;
    private UserDao userDao;

    public UserService() {
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息: " + userDao.queryUserName(uid));
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uid='" + uid + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", userDao=" + userDao +
                '}';
    }
}
