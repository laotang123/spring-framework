package pers.ljf.spring.debug.cycle;

/**
 * @author: ljf
 * @date: 2021/3/30 5:20
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class A {
	private B b;


	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}


}
