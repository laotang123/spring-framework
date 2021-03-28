package pers.ljf.spring.debug.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author: ljf
 * @date: 2021/3/24 20:31
 * @description: 实现aware接口的对象
 * @modified By：
 * @version: $ 1.0
 */
public class PersonAware implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware {
	private String beanName;
	private ClassLoader classLoader;
	private BeanFactory beanFactory;

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	public String getBeanName() {
		return this.beanName;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public ClassLoader getClassLoader() {
		return this.classLoader;
	}

	public BeanFactory getBeanFactory() {
		return this.beanFactory;
	}
}
