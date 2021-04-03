package pers.ljf.spring.debug.selfconverter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author: ljf
 * @date: 2021/4/2 13:43
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class StudentConverter implements Converter<String, Student> {
	@Override
	public Student convert(String source) {
		System.out.println("start converter str to student");
		Student student = new Student();
		String[] split = source.split("_");
		student.setName(split[0]);
		student.setAge(Integer.parseInt(split[1]));
		return student;
	}
}
