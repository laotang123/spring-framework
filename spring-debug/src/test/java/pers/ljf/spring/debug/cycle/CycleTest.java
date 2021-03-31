package pers.ljf.spring.debug.cycle;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		C bean = context.getBean(C.class);
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		System.out.println(context.getBeanDefinitionCount());
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		System.out.println("alreadyCreated set: " + beanFactory.getAlreadyCreated());
		System.out.println("containedBeanMap: " + beanFactory.getContainedBeanMap());
		System.out.println(bean);
		bean.m1();
	}
}
