package practice.zhuangzg.springframework.core.io;

import practice.zhuangzg.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author: ZhuangZG
 * @date 2022/6/20 10:14
 * @Description:
 */
public class ClassPathResource implements Resource {

    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = Objects.isNull(classLoader) ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (Objects.isNull(inputStream)) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return inputStream;
    }
}
