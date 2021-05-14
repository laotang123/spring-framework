package com.golaxy.springmvc.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ljf
 * @date: 2021/4/15 15:35
 * @description: //@InitBinder注解
 * @modified By：
 * @version: $ 1.0
 */
@Controller
public class HelloController {
	//属性转换
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, customDateEditor);
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@ResponseBody
	@GetMapping("/init-binder/param")
	public Map<String, Object> getFormatData(Date date) {
//		System.out.println(date);
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(dateFormat.format(date));
		Map<String, Object> map = new HashMap<>();
		map.put("name", "张三");
		map.put("age", 18);
		map.put("date", date);
		return map;
	}
}
