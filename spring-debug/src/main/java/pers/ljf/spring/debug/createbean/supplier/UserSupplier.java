package pers.ljf.spring.debug.createbean.supplier;

import pers.ljf.spring.debug.entity.User;

import java.util.function.Supplier;

/**
 * @author: ljf
 * @date: 2021/4/6 10:32
 * @description: 实现supplier接口来创建对象
 * 修改BeanDefinition属性，思路：
 * 1.创建BeanFactoryPostProcessor
 * 2.实现BeanFactory的扩展方法 customizeBeanFactory
 * @modified By：
 * @version: $ 1.0
 */
public class UserSupplier implements Supplier<User> {
	@Override
	public User get() {
		User user = new User();
		user.setId(1002);
		user.setName("lili");
		return user;
	}
}
