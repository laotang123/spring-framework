package pers.ljf.spring.debug.factory;

import org.springframework.beans.factory.FactoryBean;
import pers.ljf.spring.debug.entity.Person;

/**
 * @author: ljf
 * @date: 2021/3/24 20:18
 * @description: 实现FactoryBean接口
 * 用户控制bean对象的获取
 * @modified By：
 * @version: $ 1.0
 */
public class PersonFactoryBean implements FactoryBean<Person> {
	@Override
	public Person getObject() throws Exception {
		return new Person();
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
