package practice.zhuangzg.springframework.test.bean;

import practice.zhuangzg.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author: ZhuangZG
 * @date 2022/6/28 6:56
 * @Description:
 */
public class ProxyFactoryBean implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {

            if ("toString".equals(method.getName())) return this.toString();

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "AAA");
            hashMap.put("10002", "BBB");
            hashMap.put("10003", "CCC");

            return "你被代理了 " + method.getName() + ": " + hashMap.get(args[0].toString());
        });
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
