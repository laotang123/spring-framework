package pers.ljf.spring.debug;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.configuration.BoyController;
import pers.ljf.spring.debug.configuration.Toyota;
import pers.ljf.spring.debug.configuration.Volkswagen;
import pers.ljf.spring.debug.entity.Person;

import java.util.Arrays;

/**
 * @author: ljf
 * @date: 2021/3/26 11:34
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class MainTest {
	@Test
	public void testXmlPlaceHolder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-${username}.xml");
		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}

	@Test
	public void testComponentScan() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		System.out.println(context.getBean("person").hashCode());
		System.out.println(context.getBean("person").hashCode());
	}

	@Test
	public void testConfiguration() {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		((Toyota) context.getBean("toyota")).print();
		((Volkswagen) context.getBean("volkswagen")).print();

		context.getBean(BoyController.class).showBoy();
	}
}
