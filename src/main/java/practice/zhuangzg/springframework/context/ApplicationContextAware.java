package practice.zhuangzg.springframework.context;

import practice.zhuangzg.springframework.beans.BeansException;
import practice.zhuangzg.springframework.beans.factory.Aware;

/**
 * @author: ZhuangZG
 * @date 2022/6/27 13:01
 * @Description:
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
