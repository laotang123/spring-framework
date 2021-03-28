package pers.ljf.spring.debug.xml;

import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.w3c.dom.Element;

/**
 * @author: ljf
 * @date: 2021/3/27 20:53
 * @description: 实现xml解析前后的处理
 * @modified By:
 * @version: $ 1.0
 */
public class MyDefaultBeanDefinitionDocumentReader extends DefaultBeanDefinitionDocumentReader {

	@Override
	protected void preProcessXml(Element root) {
		System.out.println("invoke MyDefaultBeanDefinitionDocumentReader preProcessXml method");
		System.out.println(root.getTagName());
	}

	@Override
	protected void postProcessXml(Element root) {
		System.out.println("invoke MyDefaultBeanDefinitionDocumentReader postProcessXml method");
		System.out.println(root.getTagName());
	}
}
