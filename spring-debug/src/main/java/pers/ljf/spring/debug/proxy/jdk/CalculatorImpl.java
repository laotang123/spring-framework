package pers.ljf.spring.debug.proxy.jdk;

/**
 * @author: ljf
 * @date: 2021/4/9 9:31
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class CalculatorImpl implements ICalculator {
	@Override
	public int add(int i, int j) {
		return i + j;
	}

	@Override
	public int sub(int i, int j) {
		return i - j;
	}

	@Override
	public int mul(int i, int j) {
		return i * j;
	}

	@Override
	public int div(int i, int j) {
		return i / j;
	}
}
