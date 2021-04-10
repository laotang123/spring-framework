package pers.ljf.spring.debug.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import pers.ljf.spring.debug.proxy.cglib.CglibProxyFactory;
import pers.ljf.spring.debug.proxy.cglib.MyCalculator;
import pers.ljf.spring.debug.proxy.jdk.CalculatorImpl;
import pers.ljf.spring.debug.proxy.jdk.ICalculator;
import pers.ljf.spring.debug.proxy.jdk.JDKProxyFactory;

/**
 * @author: ljf
 * @date: 2021/4/9 10:05
 * @description: 代理模式测试
 * @modified By:
 * @version: $ 1.0
 */
public class ProxyTest {
	@Test
	public void JdkProxyTest() {
		CalculatorImpl calculator = new CalculatorImpl();
		//jdk基于接口实现代理，强转只能转为接口，代理类和被代理类都是ICalculator的实现类
		ICalculator proxy = (ICalculator) JDKProxyFactory.getProxy(calculator);
		System.out.println(proxy);
		System.out.println(proxy.add(1, 2));
	}

	@Test
	public void cglibProxyTest() {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "build/proxy");
		MyCalculator myCalculator = new MyCalculator();
		MyCalculator proxy = (MyCalculator) CglibProxyFactory.getProxy(myCalculator);
		//生成的代理类proxy是MyCalculator的子类，子类重写父类的方法插入了aop方法
		System.out.println(MyCalculator.class.isAssignableFrom(proxy.getClass()));

		System.out.println(myCalculator.getClass());
		System.out.println(proxy.getClass());
		System.out.println(proxy.sub(4, 2));
	}
}
