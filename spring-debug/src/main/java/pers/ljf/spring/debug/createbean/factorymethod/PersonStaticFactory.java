package pers.ljf.spring.debug.createbean.factorymethod;

import pers.ljf.spring.debug.entity.Person;

/**
 * @author: ljf
 * @date: 2021/4/6 11:17
 * @description: 静态工厂来创建对象
 * @modified By：
 * @version: $ 1.0
 */
public class PersonStaticFactory {
	public static Person getPerson(String name) {
		Person person = new Person();
		person.setName(name);
		return person;
	}
}
