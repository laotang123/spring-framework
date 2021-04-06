package pers.ljf.spring.debug.createbean.instantiationawareBPP;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import pers.ljf.spring.debug.entity.Person;

/**
 * @author: ljf
 * @date: 2021/4/6 9:28
 * @description: 通过instantiationAwareBPP接口来创建对象
 * @modified By：
 * @version: $ 1.0
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBean(Class)
 * 调用resolveBeforeInstantiation方法
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		Person person = null;
		if (beanClass == Person.class) {
			//动态代理增强对象
			Enhancer enhancer = new Enhancer();

			//设置enhancer对象的父类
			enhancer.setSuperclass(beanClass);

			//设置enhancer的回调对象
			enhancer.setCallback(new MyMethodInterceptor());

			//创建代理对象
			person = (Person) enhancer.create();
			person.setName("tom");
			person.setAge(30);
		}
		return person;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		return true;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
