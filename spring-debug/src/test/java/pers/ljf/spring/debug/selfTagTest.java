package pers.ljf.spring.debug;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.selftag.User;

/**
 * @author: ljf
 * @date: 2021/3/27 11:40
 * @description: 自定义标签测试
 * @modified By:
 * @version: $ 1.0
 */
public class selfTagTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("selftag.xml");
		User user = (User)context.getBean("testBean");
		System.out.println(user);
	}
}
