package com.golaxy.springmvc.self;

/**
 * @author: ljf
 * @date: 2021/4/23 10:12
 * @description: 实现httpRequestHandle接口的实现
 * @modified By：
 * @version: $ 1.0
 */
public class HttpRequestHandler implements Controller {
	public void handleRequest() {
		System.out.println("annotation controller handle request...");
	}
}
