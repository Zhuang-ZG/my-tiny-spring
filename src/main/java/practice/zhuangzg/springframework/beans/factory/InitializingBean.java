package practice.zhuangzg.springframework.beans.factory;

/**
 * @author: ZhuangZG
 * @date 2022/6/24 7:56
 * @Description:
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
