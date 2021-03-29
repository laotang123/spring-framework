package pers.ljf.spring.debug.cycle;

/**
 * @author: ljf
 * @date: 2021/3/30 5:24
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class Logger {
	public void recordBefore() {
		System.out.println("recordBefore");
	}

	public void recordAfter() {
		System.out.println("recordAfter");
	}
}
