package pers.ljf.spring.debug.cycle;

/**
 * @author: ljf
 * @date: 2021/3/30 5:21
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class B {
	private A a;

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}
}
