package pers.ljf.spring.debug.entity;

/**
 * @author: ljf
 * @date: 2021/4/6 10:12
 * @description: 实体类
 * @modified By：
 * @version: $ 1.0
 */
public class User {
	private String name;
	private Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", id=" + id +
				'}';
	}
}
