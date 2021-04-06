package pers.ljf.spring.debug.methodoverrides.replace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: ljf
 * @date: 2021/4/5 20:10
 * @description: replace-method截取器
 * @modified By：
 * @version: $ 1.0
 */
public class ReplaceDog implements MethodReplacer {
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("replace method: " + method);
		Arrays.stream(args).forEach(str -> System.out.println("参数：" + str));
		return obj;
	}
}
