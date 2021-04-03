package pers.ljf.spring.debug.selfconverter;

/**
 * @author: ljf
 * @date: 2021/4/2 13:47
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class Teacher {
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"student=" + student +
				'}';
	}
}
