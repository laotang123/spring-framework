package com.golaxy.springmvc.controller;

import com.golaxy.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * @author: ljf
 * @date: 2021/4/24 22:03
 * @description: 返回model view的userList
 * @modified By:
 * @version: $ 1.0
 */
@Controller
public class UserListController {
	@GetMapping("/userlist")
	public String getList(Model model) {
		System.out.println("set user list: " + model);
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("张三", 20));
		users.add(new User("李四", 21));
		model.addAttribute("users", users);
		return "userlist";
	}
}
