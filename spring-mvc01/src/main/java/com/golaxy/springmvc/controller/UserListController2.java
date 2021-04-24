package com.golaxy.springmvc.controller;

import com.golaxy.springmvc.entity.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * @author: ljf
 * @date: 2021/4/24 22:10
 * @description: 实现AbstractController(对共享session有加锁功能)
 * @modified By:
 * @version: $ 1.0
 */
public class UserListController2 extends AbstractController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" 调用 userListController2的访问方法");
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("王五", 23));
		users.add(new User("赵六", 24));
		return new ModelAndView("userlist", "users", users);
	}
}
