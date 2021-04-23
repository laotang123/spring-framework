package com.golaxy.springmvc.self;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ljf
 * @date: 2021/4/23 10:59
 * @description: handler执行链
 * handlerExecutionChain中包含interceptors拦截连和handler
 * @modified By：
 * @version: $ 1.0
 */
public class HandlerExecutionChain {
	private final List<Controller> handlerList = new ArrayList<>(4);
	private static final List<HandlerAdapter> handlerAdapters = new ArrayList<>(3);

	static {
		handlerAdapters.add(new SimpleControllerHandlerAdapter());
		handlerAdapters.add(new HttpRequestHandlerAdapter());
		handlerAdapters.add(new RequestMappingHandlerAdapter());
	}

	public void addHandler(Controller handler) {
		if (handler != null) {
			handlerList.add(handler);
		}
	}

	/**
	 * 从handlerAdapter列表中查找适合当前handler的适配器
	 */
	public HandlerAdapter getHandlerAdapter(Controller handler) {
		for (HandlerAdapter handlerAdapter : handlerAdapters) {
			if (handlerAdapter.support(handler)) {
				return handlerAdapter;
			}
		}

		//返回一个空实现，防止后面的null值判断
		return HandlerAdapter.emptyHandlerAdapter;
	}

	public void handle() {
		HandlerAdapter handlerAdapter;
		for (Controller handler : handlerList) {
			handlerAdapter = getHandlerAdapter(handler);
			handlerAdapter.handle(handler);
		}
	}
}
