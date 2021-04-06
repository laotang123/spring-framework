package pers.ljf.spring.debug.createbean.factorymethod;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.createbean.supplier.UserSupplier;

/**
 * @author: ljf
 * @date: 2021/4/6 10:41
 * @description: 扩展接口实现supplier
 * @modified By：
 * @version: $ 1.0
 */
public class ClassPathXmlApplicationWithFactoryMethod extends ClassPathXmlApplicationContext {

	//该方法实现loadBeanDefinitions之前调用，此时修改BeanDefinition是行不通的
//	@Override
//	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
//		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanFactory.getBeanDefinition("user");
//
//	}


	public ClassPathXmlApplicationWithFactoryMethod(String... configLocations) throws BeansException {
		super(configLocations);
	}

	/**
	 * 1.修改BeanDefinition的factoryBeanName和factoryMethodName
	 * 2.添加factoryBean实例
	 *
	 * @param beanFactory the BeanFactory to configure
	 */
	@Override
	protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		super.prepareBeanFactory(beanFactory);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
		System.out.println("user bean definition: " + beanDefinition);
		beanDefinition.setInstanceSupplier(new UserSupplier());
	}
}
