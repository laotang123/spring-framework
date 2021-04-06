package pers.ljf.spring.debug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.createbean.supplier.ClassPathXmlApplicationWithSupplier;
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

	/**
	 * 向BeanDefinition中填充instanceSupplier属性来创建对象
	 *
	 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory #createBeanInstance方法
	 */
	@Test
	public void supplierTest() {
		//方式一： xml中加入BeanFactoryPostProcessor
//		ApplicationContext context = new ClassPathXmlApplicationContext("supplier.xml");
//		User user = (User) context.getBean("user");
//		System.out.println(user);

		//方式二：扩展BeanFactory
		ApplicationContext context = new ClassPathXmlApplicationWithSupplier("supplier.xml");
		Object user = context.getBean("user");
		System.out.println(user);
	}

	@Test
	public void factoryMethodTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("factorymethod.xml");
		Object person1 = context.getBean("person1");
		System.out.println(person1.hashCode());
		System.out.println(context.getBean("person1").hashCode());

		Object person2 = context.getBean("person2");
		System.out.println(person2.hashCode());
		System.out.println(context.getBean("person2").hashCode());
	}
}
