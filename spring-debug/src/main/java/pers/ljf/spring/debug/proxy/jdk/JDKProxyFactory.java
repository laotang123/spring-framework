package pers.ljf.spring.debug.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: ljf
 * @date: 2021/4/9 9:33
 * @description: 代理工厂，用于返回代理对象
 * @modified By:
 * @version: $ 1.0
 */
public class JDKProxyFactory {
	public static Object getProxy(Object object) {
		Class<?> objectClass = object.getClass();
		ClassLoader classLoader = objectClass.getClassLoader();
		Class<?>[] interfaces = objectClass.getInterfaces();

		InvocationHandler invocationHandler = (proxy, method, args) -> {
			System.out.println("调用handler的invoke方法");
			return method.invoke(object, args);
		};
		return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
	}
}
