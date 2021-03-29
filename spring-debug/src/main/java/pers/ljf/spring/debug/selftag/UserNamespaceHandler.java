package pers.ljf.spring.debug.selftag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author: ljf
 * @date: 2021/3/27 11:33
 * @description: xml 用户空间的handler
 * @modified By:
 * @version: $ 1.0
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}
}
