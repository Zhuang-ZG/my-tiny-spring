package practice.zhuangzg.springframework.beans.factory;

/**
 * @author: ZhuangZG
 * @date 2022/6/24 7:57
 * @Description:
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
