package pers.ljf.spring.debug.createbean.factorymethod;

import pers.ljf.spring.debug.entity.Person;

/**
 * @author: ljf
 * @date: 2021/4/6 12:58
 * @description: 实例工厂创建person对象
 * @modified By：
 * @version: $ 1.0
 */
public class PersonInstanceFactory {
	public Person getPerson(String name) {
		Person person = new Person();
		person.setName(name);
		return person;
	}
}
