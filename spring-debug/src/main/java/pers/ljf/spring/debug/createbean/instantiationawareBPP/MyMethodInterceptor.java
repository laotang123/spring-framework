package pers.ljf.spring.debug.createbean.instantiationawareBPP;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: ljf
 * @date: 2021/4/6 9:43
 * @description: cglib 创建代理的回调函数
 * @modified By：
 * @version: $ 1.0
 */
public class MyMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		return methodProxy.invokeSuper(o, objects);
	}
}
