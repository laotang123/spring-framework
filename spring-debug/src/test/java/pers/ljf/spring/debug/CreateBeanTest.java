package pers.ljf.spring.debug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.entity.Person;
import pers.ljf.spring.debug.entity.User;

/**
 * @author: ljf
 * @date: 2021/4/6 9:53
 * @description: bean创建集中方式的测试
 * @modified By：
 * @version: $ 1.0
 */
public class CreateBeanTest {
	@Test
	public void factoryBeanTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("factoryBean.xml");
		Person person = (Person) context.getBean("myFactoryBean");
		System.out.println(person);

		MyFactoryBean myFactoryBean = (MyFactoryBean) context.getBean("&myFactoryBean");
		System.out.println(myFactoryBean);

		System.out.println(context.getBean(Person.class));
		System.out.println(context.getBean(MyFactoryBean.class));

	}

	@Test
	public void instantiationAwareBeanPostProcessorTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("instantiationAwareBPP.xml");
		InstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor = (InstantiationAwareBeanPostProcessor)
				context.getBean("myInstantiationAwareBeanPostProcessor");
		System.out.println(myInstantiationAwareBeanPostProcessor);
		System.out.println(myInstantiationAwareBeanPostProcessor.hashCode());

		System.out.println(context.getBean(Person.class));
		System.out.println(context.getBean(User.class));

	}
}
