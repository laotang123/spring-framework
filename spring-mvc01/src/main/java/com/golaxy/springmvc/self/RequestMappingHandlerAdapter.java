package com.golaxy.springmvc.self;

/**
 * @author: ljf
 * @date: 2021/4/23 10:52
 * @description: 专门用来处理@Controller修饰的请求
 * @modified By：
 * @version: $ 1.0
 */
public class RequestMappingHandlerAdapter implements HandlerAdapter {
	@Override
	public boolean support(Controller handler) {
		return handler instanceof AnnotationController;
	}

	@Override
	public void handle(Controller handler) {
		((AnnotationController) handler).func();
	}
}
