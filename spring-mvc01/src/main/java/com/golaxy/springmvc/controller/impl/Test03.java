package com.golaxy.springmvc.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: ljf
 * @date: 2021/4/24 21:32
 * @description: 使用@Controller注解来接收请求
 * @modified By:
 * @version: $ 1.0
 */
@Controller
public class Test03 {
	@GetMapping("/test03")
	@ResponseBody
	public String test() {
		System.out.println("实现controller注解...");
		return "call test method of test03 class successfully";
	}
}
