package pers.ljf.spring.debug.tx;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.tx.xml.service.BookService;

/**
 * @author: ljf
 * @date: 2021/4/11 15:07
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class TxTest {
	@Test
	public void xmlTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");
		BookService bookService = context.getBean("bookService", BookService.class);
		bookService.checkout("zhangsan",1);
	}
}
