package pers.ljf.spring.debug;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.entity.PersonAware;
import pers.ljf.spring.debug.entity.PersonLifecycle;
import pers.ljf.spring.debug.selfeditor.Customer;

/**
 * @author: ljf
 * @date: 2021/3/24 6:40
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class DemoApplication {
	public static void main(String[] args) throws InterruptedException {
//		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//		System.out.println(context.getBean("person"));
//
//		System.out.println(context.getBean("&personFactoryBean"));
//		PersonAware personAware = (PersonAware)context.getBean("personAware");
//		System.out.println(personAware.getBeanFactory());
//		System.out.println(personAware.getBeanName());
//		System.out.println(personAware.getClassLoader());
		ApplicationContext context = new MyClassPathXmlApplicationContext("application.xml");

		PersonLifecycle personLifecycle = (PersonLifecycle) context.getBean("personLifecycle");
		System.out.println(personLifecycle);
		System.out.println(context.getBeanDefinitionCount());

//		((ClassPathXmlApplicationContext) context).close();
		((ClassPathXmlApplicationContext) context).registerShutdownHook();
		System.out.println(context.getBeanDefinitionCount());
	}
}
