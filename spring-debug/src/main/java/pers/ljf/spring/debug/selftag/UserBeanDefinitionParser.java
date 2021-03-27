package pers.ljf.spring.debug.selftag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author: ljf
 * @date: 2021/3/27 11:36
 * @description: 自定义BeanDefinition的解析类
 * @modified By:
 * @version: $ 1.0
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		//	获取标签的属性值
		String username = element.getAttribute("username");
		String password = element.getAttribute("password");
		String email = element.getAttribute("email");

		if (StringUtils.hasLength(username)){
			builder.addPropertyValue("username",username);
		}

		if (StringUtils.hasLength(password)){
			builder.addPropertyValue("password",password);
		}

		if (StringUtils.hasLength(email)){
			builder.addPropertyValue("email",email);
		}

	}
}
