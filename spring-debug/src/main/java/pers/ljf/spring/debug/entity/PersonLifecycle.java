package pers.ljf.spring.debug.entity;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @author: ljf
 * @date: 2021/3/25 17:10
 * @description: bean 生命周期
 * @modified By：
 * @version: $ 1.0
 */
@Getter
@ToString
public class PersonLifecycle implements BeanNameAware, DisposableBean {
	private String name;
	private Integer age;
	private String beanName;

	public PersonLifecycle() {
		System.out.println("1.调用无参构造器");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("3.aware接口填充属性");
		this.beanName = name;
	}

	public void setName(String name) {
		System.out.println("2.set name填充属性");
		this.name = name;
	}

	public void setAge(Integer age) {
		System.out.println("2.set age填充属性");
		this.age = age;
	}


	public void initMethod() {
		System.out.println("5.调用init-method");
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("8.调用destroy方法");
	}



	public void destroyMethod(){
		System.out.println("9.调用destroy-method标签方法");
	}
}
