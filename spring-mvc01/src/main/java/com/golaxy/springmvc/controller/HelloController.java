package com.golaxy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: ljf
 * @date: 2021/4/15 15:35
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
