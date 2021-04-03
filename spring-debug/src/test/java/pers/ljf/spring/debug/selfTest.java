package pers.ljf.spring.debug;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.selfautowire.StudentController;
import pers.ljf.spring.debug.selfautowire.StudentService;
import pers.ljf.spring.debug.selfconverter.StringToInteger;
import pers.ljf.spring.debug.selfconverter.Teacher;
import pers.ljf.spring.debug.selfeditor.Customer;
import pers.ljf.spring.debug.selftag.User;

/**
 * @author: ljf
 * @date: 2021/3/27 11:40
 * @description: 自定义标签测试
 * @modified By:
 * @version: $ 1.0
 */
public class selfTest {
	@Test
	public void selfTagTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("selftag.xml");
		User user = (User) context.getBean("testBean");
		System.out.println(user);
	}


	@Test
	public void selfEditorTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("selfeditor.xml");
		Customer customer = (Customer) context.getBean("customer");
		System.out.println(customer);
	}


	@Test
	public void selfAutowireTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("selfautowire.xml");
		StudentService studentService = (StudentService) context.getBean("studentServiceImpl");
		System.out.println(studentService);

		StudentController studentController = (StudentController) context.getBean("studentController");
		System.out.println(studentController.getStudent());
	}

	@Test
	public void selfConverter() {
		ApplicationContext context = new ClassPathXmlApplicationContext("converter.xml");
		StringToInteger bean = context.getBean(StringToInteger.class);
		Teacher teacher = context.getBean(Teacher.class);
		System.out.println(teacher);
		System.out.println(bean);
	}
}
