package pers.ljf.spring.debug;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: ljf
 * @date: 2021/3/24 6:40
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class DemoApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("selftag.xml");
		System.out.println(context.getBean("testBean"));
	}
}
