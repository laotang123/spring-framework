package com.golaxy.springmvc.self;

import org.junit.jupiter.api.Test;

/**
 * @author: ljf
 * @date: 2021/4/23 11:22
 * @description: 适配器测试
 * @modified By：
 * @version: $ 1.0
 */
public class HandlerExecutionChainTest {
	@Test
	public void testAdapter() {
		HandlerExecutionChain chain = new HandlerExecutionChain();
		chain.addHandler(new ControllerImpl());
		chain.addHandler(new AnnotationController());
		chain.addHandler(new ControllerImpl());

		chain.handle();
	}
}
