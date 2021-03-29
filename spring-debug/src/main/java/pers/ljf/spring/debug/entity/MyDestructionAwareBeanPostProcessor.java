package pers.ljf.spring.debug.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author: ljf
 * @date: 2021/3/28 23:43
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		System.out.println("7.调用postProcessBeforeDestruction方法");
		System.out.println("beanName: " + beanName + "bean: " + bean);
	}
}
