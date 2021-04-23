package com.golaxy.springmvc.self;

/**
 * @author: ljf
 * @date: 2021/4/23 10:14
 * @description: 注解类型的controller
 * @modified By：
 * @version: $ 1.0
 */
public class AnnotationController implements Controller {
	public void func() {
		System.out.println("call func method");
		func1();
	}

	public void func1() {
		System.out.println("call func1 method");
		func2();
	}

	private void func2() {
		System.out.println("call func2 method");
	}
}
