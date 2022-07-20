package practice.zhuangzg.springframework.test.bean;

/**
 * @author: ZhuangZG
 * @date 2022/7/20 14:18
 * @Description:
 */
public class Husband {

    private Wife wife;

    public String queryWife(){
        return "Husband.wife";
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

}
