package practice.zhuangzg.springframework.core.io;

/**
 * @author: ZhuangZG
 * @date 2022/6/20 9:57
 * @Description:
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
