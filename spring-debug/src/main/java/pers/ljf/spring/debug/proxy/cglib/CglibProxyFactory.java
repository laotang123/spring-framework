package pers.ljf.spring.debug.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: ljf
 * @date: 2021/4/9 10:13
 * @description: cglib创建代理对象
 * @modified By:
 * @version: $ 1.0
 */
public class CglibProxyFactory {

	public static Object getProxy(Object object) {
		//创建Enhancer对象
		Enhancer enhancer = new Enhancer();
		//设置父类
		enhancer.setSuperclass(MyCalculator.class);

		//设置回调函数
		enhancer.setCallback((MethodInterceptor) (o, method, args, methodProxy) -> {
			System.out.println("调用cglib的intercept方法");
			return methodProxy.invokeSuper(o, args);
		});
		//创建代理类
		return enhancer.create();
	}
}
