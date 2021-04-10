package pers.ljf.spring.debug.proxy;

import org.junit.jupiter.api.Test;
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
		ICalculator proxy = (ICalculator) JDKProxyFactory.getProxy(calculator);
		System.out.println(proxy);
		System.out.println(proxy.add(1, 2));
	}

	@Test
	public void cglibProxyTest() {
		MyCalculator myCalculator = new MyCalculator();
		MyCalculator proxy = (MyCalculator) CglibProxyFactory.getProxy(myCalculator);
		System.out.println(proxy.sub(4, 2));
	}
}
