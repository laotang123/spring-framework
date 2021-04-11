package pers.ljf.spring.debug.cycle;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.aop.MyCalculator;

import java.util.Arrays;

/**
 * @author: ljf
 * @date: 2021/3/30 5:36
 * @description: 循环引用测试
 * @modified By:
 * @version: $ 1.0
 */
public class CycleTest {
	@Test
	public void testCycle() {
		ApplicationContext context = new ClassPathXmlApplicationContext("cycle.xml");
		A a = context.getBean(A.class);
		B b = context.getBean(B.class);
		System.out.println(a);
		System.out.println(a.getB());
		System.out.println(b);
		System.out.println(b.getA());
	}

	@Test
	public void testAOP() {
		//设置cglib的代理类class文件存储位置
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "build/proxy/aop");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		MyCalculator calculator = context.getBean(MyCalculator.class);
		System.out.println(calculator);
		int add = calculator.add(3, 4);
		System.out.println(calculator.add(3, 4));
		System.out.println(calculator.sub(3, 4));
		System.out.println(calculator.mul(3, 4));
		System.out.println(calculator.div(3, 4));
//		calculator.div(1,0);
	}
}
