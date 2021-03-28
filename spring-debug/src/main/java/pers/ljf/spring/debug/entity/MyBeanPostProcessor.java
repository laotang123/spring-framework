package pers.ljf.spring.debug.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: ljf
 * @date: 2021/3/28 23:32
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("4.调用postProcessBeforeInitialization方法");
		System.out.println("beanName: " + beanName + "bean: " + bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("6.调用postProcessAfterInitialization方法");
		System.out.println("beanName: " + beanName + "bean: " + bean);
		return bean;
	}
}
