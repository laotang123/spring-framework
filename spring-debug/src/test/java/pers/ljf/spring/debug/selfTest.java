package pers.ljf.spring.debug;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.selfautowire.StudentService;
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
		StudentService studentService = (StudentService) context.getBean("studentService");
		System.out.println(studentService);
	}
}
