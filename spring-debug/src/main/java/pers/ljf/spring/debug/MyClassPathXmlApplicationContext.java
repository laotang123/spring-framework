package pers.ljf.spring.debug;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: ljf
 * @date: 2021/3/25 19:38
 * @description: 实现initPropertySources方法
 * @modified By：
 * @version: $ 1.0
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {


	public MyClassPathXmlApplicationContext(String... configLocations) {
		super(configLocations);
	}

	@Override
	protected void initPropertySources() {
		System.out.println("invoke initPropertySources method");
		getEnvironment().setRequiredProperties("username");
	}

	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		//允许覆盖同名称的不同定义的对象
		this.setAllowBeanDefinitionOverriding(true);
		//允许bean之间的循环依赖
		this.setAllowCircularReferences(true);
		super.customizeBeanFactory(beanFactory);
	}
}
