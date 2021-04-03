package pers.ljf.spring.debug.postprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.selfautowire.StudentService;
import pers.ljf.spring.debug.selfautowire.StudentServiceImpl;

/**
 * @author: ljf
 * @date: 2021/4/1 14:00
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class PostProcessorTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("post-processor.xml");
		StudentServiceImpl service = context.getBean(StudentServiceImpl.class);
		System.out.println(service);
	}
}
