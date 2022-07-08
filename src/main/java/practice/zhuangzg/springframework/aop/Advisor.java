package practice.zhuangzg.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author: ZhuangZG
 * @date 2022/7/6 16:32
 * @Description:
 */
public interface Advisor {

    Advice getAdvice();
}
