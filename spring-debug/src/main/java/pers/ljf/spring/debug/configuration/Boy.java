package pers.ljf.spring.debug.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: ljf
 * @date: 2021/4/4 6:59
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
@Component
public class Boy {
	@Value("tom")
	private String name;

	@Value("19")
	private Integer age;

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Boy{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
