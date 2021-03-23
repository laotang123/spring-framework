package pers.ljf.spring.debug.entity;

/**
 * @author: ljf
 * @date: 2021/3/24 6:45
 * @description: TODO
 * @modified By:
 * @version: $ 1.0
 */
public class Person {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
