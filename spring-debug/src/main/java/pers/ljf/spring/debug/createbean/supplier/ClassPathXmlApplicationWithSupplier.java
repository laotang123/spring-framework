package pers.ljf.spring.debug.createbean.supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: ljf
 * @date: 2021/4/6 10:41
 * @description: 扩展接口实现supplier
 * @modified By：
 * @version: $ 1.0
 */
public class ClassPathXmlApplicationWithSupplier extends ClassPathXmlApplicationContext {

	//该方法实现loadBeanDefinitions之前调用，此时修改BeanDefinition是行不通的
//	@Override
//	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
//		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanFactory.getBeanDefinition("user");
//
//	}


	public ClassPathXmlApplicationWithSupplier(String... configLocations) throws BeansException {
		super(configLocations);
	}

	@Override
	protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		super.prepareBeanFactory(beanFactory);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
		System.out.println("user bean definition: " + beanDefinition);
		beanDefinition.setInstanceSupplier(new UserSupplier());
	}
}
