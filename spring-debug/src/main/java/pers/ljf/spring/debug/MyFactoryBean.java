package pers.ljf.spring.debug;

import org.springframework.beans.factory.FactoryBean;
import pers.ljf.spring.debug.entity.Person;

/**
 * @author: ljf
 * @date: 2021/4/3 19:48
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class MyFactoryBean implements FactoryBean<Person> {
	@Override
	public Person getObject() throws Exception {
		Person person = new Person();
		person.setName("tom");
		return person;
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
