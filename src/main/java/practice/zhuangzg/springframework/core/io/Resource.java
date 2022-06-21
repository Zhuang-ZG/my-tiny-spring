package practice.zhuangzg.springframework.core.io;

import practice.zhuangzg.springframework.beans.BeansException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: ZhuangZG
 * @date 2022/6/20 9:56
 * @Description:
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
