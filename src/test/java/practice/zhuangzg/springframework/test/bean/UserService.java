package practice.zhuangzg.springframework.test.bean;

/**
 * @author: ZhuangZG
 * @date 2022/6/16 21:42
 * @Description:
 */
public class UserService {

    private String uid;
    private String company;
    private String location;
    private IUserDao userDao;

    public UserService() {
    }


    public void queryUserInfo() {
        System.out.println("查询用户信息: " + userDao.queryUserName(uid) + ", " + company + ", " + location);
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
