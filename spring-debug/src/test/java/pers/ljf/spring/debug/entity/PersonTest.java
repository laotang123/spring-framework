package pers.ljf.spring.debug.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: ljf
 * @date: 2021/3/25 15:29
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class PersonTest {

	@Test
	public void testBase() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		PersonDestroy personDestroy = (PersonDestroy) context.getBean("personDestroy");
		System.out.println(personDestroy);
//		context.registerShutdownHook();
		context.close();
		System.out.println(personDestroy);
	}

	@Test
	public void testLifecycle() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		PersonLifecycle personLifecycle = (PersonLifecycle) context.getBean("personLifecycle");
		System.out.println(personLifecycle);
//		context.registerShutdownHook();
		context.close();
		System.out.println(personLifecycle);
	}
}
