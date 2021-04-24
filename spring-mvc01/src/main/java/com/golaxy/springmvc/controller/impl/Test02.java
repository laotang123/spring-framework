package com.golaxy.springmvc.controller.impl;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author: ljf
 * @date: 2021/4/24 21:30
 * @description: 实现httpRequestHandler来接收请求
 * @modified By:
 * @version: $ 1.0
 */
public class Test02 implements HttpRequestHandler {
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("实现HTTPRequestHandler...");
		System.out.println(request.getContextPath());
		System.out.println(Arrays.toString(request.getCookies()));
	}
}
