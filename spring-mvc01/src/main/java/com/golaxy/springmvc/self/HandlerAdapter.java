package com.golaxy.springmvc.self;

/**
 * @author: ljf
 * @date: 2021/4/22 21:08
 * @description: 适配器接口
 * @modified By：
 * @version: $ 1.0
 */
public interface HandlerAdapter {

	HandlerAdapter emptyHandlerAdapter = new HandlerAdapter() {
		@Override
		public boolean support(Controller handler) {
			return false;
		}

		@Override
		public void handle(Controller handler) {

		}
	};

	/**
	 * 检查当前适配器是否支持handler
	 */
	boolean support(Controller handler);

	/**
	 * 通过适配器的统一handle方法来访问实际的处理方法
	 */
	void handle(Controller handler);

}
