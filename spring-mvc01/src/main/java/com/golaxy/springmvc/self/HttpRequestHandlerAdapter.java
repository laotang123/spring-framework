package com.golaxy.springmvc.self;

/**
 * @author: ljf
 * @date: 2021/4/23 10:49
 * @description: http request的适配器
 * @modified By：
 * @version: $ 1.0
 */
public class HttpRequestHandlerAdapter implements HandlerAdapter {
	@Override
	public boolean support(Controller handler) {
		return handler instanceof HttpRequestHandler;
	}

	@Override
	public void handle(Controller handler) {
		((HttpRequestHandler) handler).handleRequest();
	}
}
