package pers.ljf.spring.debug.createbean.supplier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author: ljf
 * @date: 2021/4/6 10:36
 * @description: 实现user的BeanDefinition的 supplier修改
 * @modified By：
 * @version: $ 1.0
 */
public class UserSupplierBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition userBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
		System.out.println("user bean definition: " + userBeanDefinition);
		userBeanDefinition.setInstanceSupplier(new UserSupplier());
	}
}
