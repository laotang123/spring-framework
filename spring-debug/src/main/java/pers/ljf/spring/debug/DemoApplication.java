package pers.ljf.spring.debug;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import pers.ljf.spring.debug.configuration.Toyota;
import pers.ljf.spring.debug.selfconverter.StudentConverter;

/**
 * @author: ljf
 * @date: 2021/3/24 6:40
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class DemoApplication {

	static class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
		public MyClassPathXmlApplicationContext(String... configLocations) {
			super(configLocations);
		}

		@Override
		protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
			super.customizeBeanFactory(beanFactory);
//			GenericConversionService conversionService = new GenericConversionService();
			DefaultConversionService conversionService = new DefaultConversionService();
			conversionService.addConverter(new StudentConverter());
			beanFactory.setConversionService(conversionService);
		}
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new MyClassPathXmlApplicationContext("application.xml");
		System.out.println(context.getBean("toyota"));
		Toyota toyota = context.getBean(Toyota.class);
		System.out.println(toyota);
		toyota.print();
	}
}
