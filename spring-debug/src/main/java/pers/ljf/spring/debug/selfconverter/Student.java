package pers.ljf.spring.debug.selfconverter;

/**
 * @author: ljf
 * @date: 2021/4/2 13:35
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class Student {
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
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
