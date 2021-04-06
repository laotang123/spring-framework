package pers.ljf.spring.debug.methodoverrides.replace;

/**
 * @author: ljf
 * @date: 2021/4/5 20:08
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class OriginalDog {
	public void sayHello() {
		System.out.println("i am block dog, parameters: ");
	}

	public void sayHello(String name) {
		System.out.println("i am black dog, parameters: " + name);
	}
}
