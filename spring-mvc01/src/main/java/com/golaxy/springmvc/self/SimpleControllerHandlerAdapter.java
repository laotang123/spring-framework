package com.golaxy.springmvc.self;

/**
 * @author: ljf
 * @date: 2021/4/23 10:24
 * @description: ControllerImpl的适配器
 * @modified By：
 * @version: $ 1.0
 */
public class SimpleControllerHandlerAdapter implements HandlerAdapter {
	@Override
	public boolean support(Controller handler) {
		return handler instanceof ControllerImpl;
	}

	@Override
	public void handle(Controller handler) {
		((ControllerImpl) handler).handRequest();
	}
}
