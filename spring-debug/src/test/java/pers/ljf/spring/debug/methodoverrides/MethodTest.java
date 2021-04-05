package pers.ljf.spring.debug.methodoverrides;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.ljf.spring.debug.methodoverrides.lookup.FruitPlate;

/**
 * @author: ljf
 * @date: 2021/4/5 11:08
 * @description: look-up标签和replace-method标签的测试
 * @modified By：
 * @version: $ 1.0
 */
public class MethodTest {
	@Test
	public void LookUpTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("methodoverrides.xml");
		FruitPlate fruitPlate1 = (FruitPlate) context.getBean("fruitPlate1");
		FruitPlate fruitPlate2 = (FruitPlate) context.getBean("fruitPlate2");

		fruitPlate1.getFruit();
		fruitPlate2.getFruit();

	}
}
