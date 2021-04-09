package pers.ljf.spring.debug.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

/**
 * @author: ljf
 * @date: 2021/4/8 9:50
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
public class LogUtil {

	public int start(JoinPoint joinPoint) {
		//获取方法签名
		Signature signature = joinPoint.getSignature();
		//获取参数信息
		Object[] args = joinPoint.getArgs();
		System.out.println("log--" + signature.getName() + "方法开始执行，参数是：" + Arrays.toString(args));
		return 100;
	}


	public static void stop(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();
		System.out.println("log--" + signature.getName() + "方法执行结束，结果是：" + result);
	}

	public static void logException(JoinPoint joinpoint, Exception e) {
		Signature signature = joinpoint.getSignature();
		System.out.println("log--" + signature.getName() + "方法抛出异常：" + e.getMessage());
	}

	public static void logFinally(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("log--" + signature.getName() + "方法执行结束，over。。。");
	}

	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Signature signature = proceedingJoinPoint.getSignature();
		Object[] args = proceedingJoinPoint.getArgs();

		Object result = null;
		try {
			System.out.println("log--环绕通知start：" + signature.getName() + "方法开始执行，参数为：" + Arrays.toString(args));
			//通过反射调用目标方法
			result = proceedingJoinPoint.proceed(args);
			System.out.println("log--环绕通知stop：" + signature.getName() + "方法执行结束");
		} catch (Throwable throwable) {
			System.out.println("log--环绕异常通知：" + signature.getName() + "出现异常");
			throw throwable;
		} finally {
			System.out.println("log--环绕返回通知：" + signature.getName() + "方法返回执行结果是：" + result);
		}
		return result;
	}


}
