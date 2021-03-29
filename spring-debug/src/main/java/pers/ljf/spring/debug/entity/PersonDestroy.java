package pers.ljf.spring.debug.entity;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author: ljf
 * @date: 2021/3/25 15:36
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class PersonDestroy implements DisposableBean {
	private String name;
	private Integer age;

	@Override
	public void destroy() throws Exception {
		System.out.println("释放对象");
		this.name = null;
		this.age = null;
	}

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
		return "PersonDestroy{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}



