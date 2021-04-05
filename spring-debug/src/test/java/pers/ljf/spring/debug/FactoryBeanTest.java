package pers.ljf.spring.debug;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.entity.Person;

/**
 * @author: ljf
 * @date: 2021/4/3 19:51
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class FactoryBeanTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("factoryBean.xml");
		Person person = (Person) context.getBean("myFactoryBean");
		System.out.println(person);

		MyFactoryBean myFactoryBean = (MyFactoryBean) context.getBean("&myFactoryBean");
		System.out.println(myFactoryBean);

		System.out.println(context.getBean(Person.class));
		System.out.println(context.getBean(MyFactoryBean.class));
	}
}
