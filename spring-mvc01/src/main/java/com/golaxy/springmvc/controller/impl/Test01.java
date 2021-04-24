package com.golaxy.springmvc.controller.impl;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: ljf
 * @date: 2021/4/24 21:17
 * @description: 实现controller接口
 * handler类型
 * @modified By:
 * @version: $ 1.0
 */
public class Test01 implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("实现controller接口....");
		return new ModelAndView("hello");
	}
}
